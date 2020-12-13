package com.johan.septian.myberitacnn.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.johan.septian.myberitacnn.R
import com.johan.septian.myberitacnn.adapter.BeritaAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    companion object {
        var EXTRA_NAME = "extra_name"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_search.setHasFixedSize(true)
        if (arguments != null) {
            val userName = arguments?.getString(EXTRA_NAME)
            setSearch(userName)
        }
    }

    private fun setSearch(username: String?) {
        searchViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(SearchViewModel::class.java)
        context?.let { searchViewModel.loadSearchBerita(it,username) }
        searchViewModel.getListSearchBerita.observe(viewLifecycleOwner, Observer {
            rv_search.adapter = BeritaAdapter(context, it)
            Log.d("ResponApi",it.toString())
        })
        rv_search.layoutManager = LinearLayoutManager(context)
    }
}