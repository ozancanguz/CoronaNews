package com.ozancanguz.coronanews.ui.fragments.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.coronanews.adapter.NewsAdapter
import com.ozancanguz.coronanews.databinding.FragmentNewsBinding
import com.ozancanguz.coronanews.util.observeOnce
import com.ozancanguz.coronanews.viewmodels.CoronaNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!
    private val coronaNewsViewModel:CoronaNewsViewModel by viewModels()

    private var newsAdapter=NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRv()

        // instead of observelive data we call list from db
       // observeLiveData()

        listFromDatabase()
        return view

    }

    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=newsAdapter
    }

    private fun listFromDatabase(){

        lifecycleScope.launch {
               coronaNewsViewModel.newsList.observeOnce(viewLifecycleOwner, Observer { database ->
                  Log.d("coronaviewmodel","database called")
                   if(database.isNotEmpty()){
                        newsAdapter.setData(database[0].coronaNews)
                   }
                   else{
                       Log.d("coronaviewmodel","api called")
                       observeLiveData()
                   }

               })
        }
    }


    private fun observeLiveData() {
        coronaNewsViewModel.requestApiData()
        coronaNewsViewModel.coronaNewsList.observe(viewLifecycleOwner, Observer { news ->

            newsAdapter.setData(news)

        })
    }

    private fun loadDataFromCache() {
        lifecycleScope.launch {
            coronaNewsViewModel.newsList.observe(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    newsAdapter.setData(database[0].coronaNews)
                }
            }
        }
    }




}