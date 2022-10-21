package com.example.shaditask.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.domain.usecase.GetRemoteProfilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRemoteProfilesUseCase: GetRemoteProfilesUseCase
) : ViewModel() {
    private val remoteProfiles = MutableLiveData<ApiResponse>()
    val routeRemoteProfiles: LiveData<ApiResponse> = remoteProfiles

    fun getRemoteProfiles() {
        viewModelScope.launch(Dispatchers.IO) {
            val apiResult = getRemoteProfilesUseCase.execute()
            if (apiResult.isSuccessful) {
                remoteProfiles.postValue(apiResult.body())
            }
        }
    }
}