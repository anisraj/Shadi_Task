package com.example.shaditask.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shaditask.R
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var profileAdapter: ProfileAdapter
    private var data: ArrayList<ApiResponse.Result?> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()
        viewProfileList()
    }

    private fun initRecyclerview() {
        profileAdapter = ProfileAdapter(data)
        profileAdapter.setAcceptClickListener { result ->
            viewModel.updateProfile(result, true)
        }
        profileAdapter.setRejectClickListener { result ->
            viewModel.updateProfile(result, false)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = profileAdapter
        }
    }

    private fun viewProfileList() {
        viewModel.getLocalProfiles()
        viewModel.routeRemoteProfiles.observe(this) {
            data.clear()
            data.addAll(it)
            profileAdapter.notifyDataSetChanged()
        }
    }
}