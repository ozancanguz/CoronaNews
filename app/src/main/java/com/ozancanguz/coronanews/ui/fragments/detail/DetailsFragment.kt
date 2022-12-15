package com.ozancanguz.coronanews.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.databinding.FragmentDetailsBinding
import com.ozancanguz.coronanews.util.Utils.Companion.loadImage


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null

    private val args:DetailsFragmentArgs by navArgs()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateData()

        return view
    }

    private fun updateData() {
        binding.detailsDescriptionTv.text=args.currentNews.description
        binding.detailsImage.loadImage(args.currentNews.image)
    }


}