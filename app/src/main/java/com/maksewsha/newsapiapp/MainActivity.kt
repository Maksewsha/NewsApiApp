package com.maksewsha.newsapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maksewsha.newsapiapp.presentation.fragments.NewsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, NewsListFragment(), "NewsListFragment").commit()
    }
}