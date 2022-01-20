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

    @Inject
    lateinit var viewModelFactory: NewsViewModelProviderFactory

    lateinit var binding : ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as NewsApplication).appComponent.inject(this)

        val newsRepository = NewsRepository()
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
    }
}
