package com.ozancanguz.coronanews.ui.fragments.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.databinding.FragmentNewsBinding
import com.ozancanguz.coronanews.viewmodels.CoronaNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!
    private val coronaNewsViewModel:CoronaNewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val view = binding.root


        observeLiveData()
        return view

    }

    private fun observeLiveData() {
        coronaNewsViewModel.requestApiData()
        coronaNewsViewModel.coronaNewsList.observe(viewLifecycleOwner, Observer {
            Log.d("newsFragment", " $it")
        })
    }


}