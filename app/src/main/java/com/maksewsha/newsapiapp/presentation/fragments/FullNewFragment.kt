package com.maksewsha.newsapiapp.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.maksewsha.newsapiapp.R
import com.maksewsha.newsapiapp.presentation.models.ArticlePresentation

class FullNewFragment: Fragment(R.layout.full_new_fragment) {

    private lateinit var title: TextView
    private lateinit var content:TextView
    private lateinit var publishedAt: TextView
    private lateinit var url: TextView
    private lateinit var image: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.full_new_title)
        content = view.findViewById(R.id.full_new_content)
        publishedAt = view.findViewById(R.id.full_new_published)
        url = view.findViewById(R.id.full_new_url)
        image = view.findViewById(R.id.full_new_image)

        if(arguments != null){
            val info: ArticlePresentation = requireArguments().getParcelable("news")!!
            title.text = info.title
            content.text = info.content
            publishedAt.text = info.publishedAt
            url.text = info.url
            Glide.with(requireContext())
                .load(info.urlToImage)
                .error(R.drawable.no_image)
                .override(500, 500)
                .fitCenter()
                .into(image)
        }
    }
}