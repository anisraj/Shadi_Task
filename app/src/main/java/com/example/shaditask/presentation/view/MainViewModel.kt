package com.example.shaditask.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.domain.usecase.GetLocalProfilesUseCase
import com.example.shaditask.domain.usecase.GetRemoteProfilesUseCase
import com.example.shaditask.domain.usecase.SaveProfilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRemoteProfilesUseCase: GetRemoteProfilesUseCase,
    private val saveProfilesUseCase: SaveProfilesUseCase,
    private val getLocalProfilesUseCase: GetLocalProfilesUseCase
) : ViewModel() {
    private val remoteProfiles = MutableLiveData<List<ApiResponse.Result>>()
    val routeRemoteProfiles: LiveData<List<ApiResponse.Result>> = remoteProfiles

    fun getRemoteProfiles() {
        viewModelScope.launch(Dispatchers.IO) {
            val apiResult = getRemoteProfilesUseCase.execute()
            if (apiResult.isSuccessful) {
                remoteProfiles.postValue(apiResult.body()?.results!! as List<ApiResponse.Result>?)
                for(item in apiResult.body()?.results!!) {
                    if (item != null) {
                        viewModelScope.launch {
                            saveProfilesUseCase.execute(item)
                        }
                    }
                }
            }
        }
    }

    fun getLocalProfiles() {
        viewModelScope.launch {
            getLocalProfilesUseCase.execute().collect {
                if (it.isEmpty()) {
                    getRemoteProfiles()
                } else {
                    remoteProfiles.postValue(it)
                }
            }
        }
    }

    fun updateProfile(data: ApiResponse.Result, action: Boolean) {
        viewModelScope.launch {
            if (action) {
                data.isAccepted = true
            } else {
                data.isRejected = true
            }
            saveProfilesUseCase.execute(data)
            getLocalProfiles()
        }
    }
}