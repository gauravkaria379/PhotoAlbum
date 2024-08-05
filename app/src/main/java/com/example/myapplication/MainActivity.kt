package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import viewModel.CustomViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var customViewModel: CustomViewModel
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initViews()
        prepareRecyclerView()
        getAPICall()
        setData()
    }

    private fun setData() {
        binding.progress.visibility = View.GONE
        customViewModel.observePhotoLiveData().observe(this, Observer { list ->
            customAdapter.setPhotoList(list)
        })
    }

    private fun initViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customViewModel = ViewModelProvider(this)[CustomViewModel::class.java]

    }

    private fun prepareRecyclerView() {
        customAdapter = CustomAdapter(this@MainActivity)
        binding.rvListing.apply {
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter = customAdapter
        }
    }

    private fun getAPICall() {
        customViewModel.getPhotosListing()
        binding.progress.isVisible = true
    }
}