package com.johan.septian.myberitacnn.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.johan.septian.myberitacnn.R
import com.johan.septian.myberitacnn.adapter.BeritaAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_home.setHasFixedSize(true)
        setBerita()
    }

    private fun setBerita(){
        homeViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            HomeViewModel::class.java
        )
        homeViewModel.loadBerita(context)
        homeViewModel.getListBerita.observe(viewLifecycleOwner, Observer {
            rv_home.adapter = BeritaAdapter(context, it)
            Log.d("ResponApi", it.toString())
            showLoading(false)
        })
        rv_home.layoutManager = LinearLayoutManager(context)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}