package com.maksewsha.newsapiapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maksewsha.newsapiapp.R
import com.maksewsha.newsapiapp.presentation.fragments.FullNewFragment
import com.maksewsha.newsapiapp.presentation.models.ArticlePresentation

class RecyclerViewAdapter(private val news: List<ArticlePresentation>) :
    RecyclerView.Adapter<RecyclerViewAdapter.NewsHolder>() {

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.new_title)
        val image = itemView.findViewById<ImageView>(R.id.news_image)
        val cardItem = itemView.findViewById<CardView>(R.id.card_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_news, parent, false)
        return NewsHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.cardItem.setOnClickListener {
            val fragmentToShow = FullNewFragment()
            val bundle = Bundle()
            bundle.putParcelable("news", news[position])
            fragmentToShow.arguments = bundle
            (holder.itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, fragmentToShow, "FullNewFragment")
                .addToBackStack("FullNewFragment")
                .commit()
        }
        holder.title.text = news[position].title
        Glide.with(holder.itemView.context)
            .load(news[position].urlToImage)
            .error(R.drawable.no_image)
            .override(500, 500)
            .fitCenter()
            .into(holder.image)
        Log.d("tagtag", "${holder.title.text} --- ${news[position].title}")
    }

    override fun getItemCount(): Int {
        return news.size
    }
}