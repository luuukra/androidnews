package com.example.androidnewschoco.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidnewschoco.NewsApplication
import com.example.androidnewschoco.viewmodels.NewsViewModel
import com.example.androidnewschoco.viewmodels.NewsViewModelProviderFactory
import com.example.androidnewschoco.data.repository.NewsRepository
import com.example.androidnewschoco.databinding.ActivityNewsBinding
import javax.inject.Inject

class NewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBinding

    @Inject
    lateinit var viewModelFactory: NewsViewModelProviderFactory
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        (applicationContext as NewsApplication).appComponent.injectActivity(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
    }
}
