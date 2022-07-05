package com.maksewsha.newsapiapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.newsapiapp.presentation.fragments.NewsListFragment
import com.maksewsha.newsapiapp.presentation.viewmodels.NewsViewModel
import com.maksewsha.newsapiapp.presentation.viewmodels.NewsViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var dialogEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogEditText = EditText(this)
        viewModel =
            ViewModelProvider(viewModelStore, NewsViewModelFactory()).get(NewsViewModel::class.java)


        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, NewsListFragment(), "NewsListFragment").commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_news -> {
                AlertDialog.Builder(this).setTitle(R.string.alert_title).setView(dialogEditText)
                    .setPositiveButton(R.string.alert_positive) { dialog, which ->
                        viewModel.getNews(dialogEditText.text.toString())
                    }.setNegativeButton(R.string.alert_negative) { dialog, _ ->
                        dialog.cancel()
                        (dialogEditText.parent as ViewGroup).removeView(dialogEditText)
                    }.create().show()
            }
        }
        return true
    }
}