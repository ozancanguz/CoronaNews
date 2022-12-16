package com.ozancanguz.coronanews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.data.db.favorites.FavoritesEntity
import com.ozancanguz.coronanews.ui.fragments.favorite.FavoriteFragmentDirections
import com.ozancanguz.coronanews.util.Utils.Companion.loadImage
import kotlinx.android.synthetic.main.favorite_news_row_layout.view.*

class FavoritesAdapter:RecyclerView.Adapter<FavoritesAdapter.FavViewHolder>() {


    var favList= emptyList<FavoritesEntity>()

    fun setFavData(newData:List<FavoritesEntity>){
        this.favList=newData
        notifyDataSetChanged()
    }

    class FavViewHolder(val view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.favorite_news_row_layout,parent,false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        var currentFavItem=favList[position]
        holder.itemView.favorites_img.loadImage(currentFavItem.result.image)
        holder.itemView.favorites_name.text=currentFavItem.result.name
        holder.itemView.favorites_date.text=currentFavItem.result.date

        holder.itemView.setOnClickListener {
            val action=FavoriteFragmentDirections.actionFavoriteFragmentToDetailsFragment(currentFavItem.result)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return favList.size
    }


}