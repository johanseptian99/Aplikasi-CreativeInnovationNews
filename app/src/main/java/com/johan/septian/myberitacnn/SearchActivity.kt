package com.johan.septian.myberitacnn

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.johan.septian.myberitacnn.adapter.BeritaAdapter
import com.johan.septian.myberitacnn.fragment.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var searchViewModel: SearchViewModel

    companion object {
        var EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        rv_Search.setHasFixedSize(true)

        val name = intent.getStringExtra(EXTRA_NAME)
        supportActionBar?.title = "pencarian $name"
        setSearch(name)
    }

    private fun setSearch(username: String?) {
        searchViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(SearchViewModel::class.java)
        applicationContext?.let { searchViewModel.loadSearchBerita(it,username) }
        searchViewModel.getListSearchBerita.observe(this, Observer {
            rv_Search.adapter = BeritaAdapter(applicationContext, it)
            Log.d("ResponApi",it.toString())
            showLoading(false)
        })
        rv_Search.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBarSearch.visibility = View.VISIBLE
        } else {
            progressBarSearch.visibility = View.GONE
        }
    }
}