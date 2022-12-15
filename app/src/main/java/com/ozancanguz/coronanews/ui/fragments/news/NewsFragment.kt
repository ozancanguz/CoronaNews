package com.ozancanguz.coronanews.ui.fragments.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_detailsFragment)
        }

        return view

    }


}