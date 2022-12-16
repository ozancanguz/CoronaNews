package com.ozancanguz.coronanews.ui.fragments.detail

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.data.db.favorites.FavoritesEntity
import com.ozancanguz.coronanews.databinding.FragmentDetailsBinding
import com.ozancanguz.coronanews.util.Utils.Companion.loadImage
import com.ozancanguz.coronanews.viewmodels.CoronaNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null

    private val args:DetailsFragmentArgs by navArgs()
    private val mainViewModel:CoronaNewsViewModel by viewModels()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        setHasOptionsMenu(true)


        updateData()





        return view
    }


    // create menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_to_fav,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // save to favorites
        }else if(item.itemId ==R.id.savetofavmenu){
            saveToFavorites(item)
        }
        return super.onOptionsItemSelected(item)
    }


    private fun saveToFavorites(item: MenuItem){
           var favoritesEntity=FavoritesEntity(0,args.currentNews)
         mainViewModel.insertFavoriteNews(favoritesEntity)
        changeMenuItemColor(item,R.color.yellow)
       Toast.makeText(requireContext(),"Fav news saved",Toast.LENGTH_LONG).show()
    }

    private fun changeMenuItemColor(item: MenuItem, color: Int) {
        item.icon?.setTint(ContextCompat.getColor(requireContext(),color))
    }






    private fun updateData() {
        binding.detailsDescriptionTv.text=args.currentNews.description
        binding.detailsImage.loadImage(args.currentNews.image)
    }


}