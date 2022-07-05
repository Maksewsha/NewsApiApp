package com.maksewsha.newsapiapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.maksewsha.newsapiapp.R
import com.maksewsha.newsapiapp.presentation.RecyclerViewAdapter
import com.maksewsha.newsapiapp.presentation.models.ArticlePresentation
import com.maksewsha.newsapiapp.presentation.models.ArticlesRespPresentation
import com.maksewsha.newsapiapp.presentation.viewmodels.NewsViewModel
import com.maksewsha.newsapiapp.presentation.viewmodels.NewsViewModelFactory

class NewsListFragment: Fragment(R.layout.news_list_fragment) {

    private lateinit var recyclerNews: RecyclerView
    private lateinit var newsViewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel = ViewModelProvider(this, NewsViewModelFactory()).get(NewsViewModel::class.java)
        newsViewModel.getNews()

        Log.d("tag", newsViewModel.news.value.toString())

        recyclerNews = view.findViewById(R.id.news_list_recycler_view)
        recyclerNews.layoutManager = LinearLayoutManager(requireContext())
        newsViewModel.news.observe(viewLifecycleOwner, object: Observer<ArticlesRespPresentation>{
            override fun onChanged(t: ArticlesRespPresentation?) {
                recyclerNews.adapter = RecyclerViewAdapter(t?.articles!!)
            }
        })
        newsViewModel.errorMessage.observe(viewLifecycleOwner, object: Observer<String>{
            override fun onChanged(t: String?) {
                Snackbar.make(requireContext(), view, t!!, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}