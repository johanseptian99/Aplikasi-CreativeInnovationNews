package com.johan.septian.myberitacnn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.johan.septian.myberitacnn.fragment.DetailViewModel
import com.johan.septian.myberitacnn.model.ItemNews
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel

    companion object{
        const val EXTRA_URL = "extra_url"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initData()
    }

    private fun initData() {
        val item = intent.getParcelableExtra<ItemNews>(EXTRA_URL)
        if (item != null) {

            detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)
            detailViewModel.loadDetailBerita(applicationContext, item.link)
            detailViewModel.getListDetailBerita.observe(this, Observer {
                Glide.with(applicationContext)
                    .load(it[0].poster)
                    .into(findViewById(R.id.imageViewDetail))
                supportActionBar?.title = "Detail Berita"
                DetailJudul.text = it[0].judul
                DetailBody.text = it[0].body


                val fab: View = findViewById(R.id.fab)
                fab.setOnClickListener { view ->
                    val notifSnackbar = getString(R.string.notif_snackbar)
                    Snackbar.make(view, notifSnackbar, Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                }
            })
        }
    }

}