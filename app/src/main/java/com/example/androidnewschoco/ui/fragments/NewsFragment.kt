package com.example.androidnewschoco.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidnewschoco.NewsApplication
import com.example.androidnewschoco.R
import com.example.androidnewschoco.adapters.NewsAdapter
import com.example.androidnewschoco.data.repository.NewsRepository
import com.example.androidnewschoco.databinding.FragmentArticleBinding
import com.example.androidnewschoco.databinding.FragmentNewsBinding
import com.example.androidnewschoco.ui.NewsActivity
import com.example.androidnewschoco.viewmodels.NewsViewModel
import com.example.androidnewschoco.viewmodels.NewsViewModelProviderFactory
import javax.inject.Inject

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var viewModelFactory: NewsViewModelProviderFactory
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupRecyclerView()
        setupNavigation()
        setupObservers()
    }

    private fun setupViewModel() {
        (requireContext().applicationContext as NewsApplication).appComponent.injectFragment(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
    }

    private fun setupObservers() {
        viewModel.news.observe(viewLifecycleOwner, Observer { newsResponse ->
            newsAdapter.differ.submitList(newsResponse.articles.toList())
        })
    }

    private fun setupNavigation() {
        newsAdapter.setOnItemClickListener {
            findNavController().navigate(NewsFragmentDirections.actionAllNewsFragmentToArticleFragment(it))
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}