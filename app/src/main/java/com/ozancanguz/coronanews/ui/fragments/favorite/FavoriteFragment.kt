package com.ozancanguz.coronanews.ui.fragments.favorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.adapter.FavoritesAdapter
import com.ozancanguz.coronanews.databinding.FragmentFavoriteBinding
import com.ozancanguz.coronanews.viewmodels.CoronaNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!

    private var favAdapter=FavoritesAdapter()
    private val mainViewModel:CoronaNewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root

        // set up rv
        setUpRv()

        // observe live data
        observeLiveData()

        // set menu
        setHasOptionsMenu(true)


        return view
    }

    private fun setUpRv() {

        binding.favoriteRecipesRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.favoriteRecipesRecyclerView.adapter=favAdapter

    }

    private fun observeLiveData() {
        mainViewModel.favoritesNews.observe(viewLifecycleOwner, Observer {
             favAdapter.setFavData(it)
        })
    }

    // create menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.delete_all_menu,menu)
    }


}