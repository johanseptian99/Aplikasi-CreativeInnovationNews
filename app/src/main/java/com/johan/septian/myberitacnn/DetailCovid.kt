package com.johan.septian.myberitacnn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.johan.septian.myberitacnn.fragment.DetailViewModel
import com.johan.septian.myberitacnn.model.DataCovid
import com.johan.septian.myberitacnn.model.ItemNews
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail_covid.*

class DetailCovid : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_covid)
        initDataCovid()
    }

    private fun initDataCovid() {
        val item = intent.getParcelableExtra<DataCovid>(DetailCovid.EXTRA_DATA)
        if (item != null) {
            val nProvinsi = item.provinsi.toString()
            val jPos = item.kasusPosi.toString()
            val jSemb = item.kasusSemb.toString()
            val jMeni = item.kasusMeni.toString()

            supportActionBar?.title = "Statistik Covid $nProvinsi"
            detailKasusPositif.setText(jPos)
            detailKasusSembuh.setText(jSemb)
            detailKasusMeninggal.setText(jMeni)
        }
    }

}