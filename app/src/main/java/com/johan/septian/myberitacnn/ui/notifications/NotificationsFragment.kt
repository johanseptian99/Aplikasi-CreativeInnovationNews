package com.johan.septian.myberitacnn.ui.notifications

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
import com.johan.septian.myberitacnn.adapter.CovidAdapter
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_notifications.setHasFixedSize(true)
        setCovid()
    }

    private fun setCovid(){
        notificationsViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                NotificationsViewModel::class.java
        )
        notificationsViewModel.loadCovid(context)
        notificationsViewModel.getListCovid.observe(viewLifecycleOwner, Observer {
            rv_notifications.adapter = CovidAdapter(context, it)
            Log.d("ResponApi", it.toString())
            showLoading(false)
        })
        rv_notifications.layoutManager = LinearLayoutManager(context)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBarCovid.visibility = View.VISIBLE
        } else {
            progressBarCovid.visibility = View.GONE
        }
    }
}