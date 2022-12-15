package com.ozancanguz.coronanews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.coronanews.R
import com.ozancanguz.coronanews.data.model.CoronaNews
import com.ozancanguz.coronanews.data.model.Result
import com.ozancanguz.coronanews.ui.fragments.news.NewsFragmentDirections
import com.ozancanguz.coronanews.util.Utils.Companion.loadImage
import kotlinx.android.synthetic.main.row_layout.view.*

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var newsList= emptyList<Result>()

    fun setData(newData:CoronaNews){
        this.newsList=newData.result
        notifyDataSetChanged()

    }

    class NewsViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.row_layout,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var currentNews=newsList[position]

        holder.itemView.news_name.text=currentNews.name
        holder.itemView.news_date.text=currentNews.date

        // with glide
        holder.itemView.news_img.loadImage(currentNews.image)

        holder.itemView.setOnClickListener {
            val directon=NewsFragmentDirections.actionNewsFragmentToDetailsFragment(currentNews)
            holder.itemView.findNavController().navigate(directon)
        }


    }

    override fun getItemCount(): Int {
       return newsList.size
    }


}