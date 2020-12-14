package com.johan.septian.myberitacnn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.johan.septian.myberitacnn.adapter.BeritaAdapter
import com.johan.septian.myberitacnn.fragment.BeritaPerkategoriViewModel
import kotlinx.android.synthetic.main.activity_berita_perkategori.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeritaPerkategori : AppCompatActivity() {

    private lateinit var beritaPerkategoriViewModel: BeritaPerkategoriViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_perkategori)

        val getData = intent.getStringExtra("data")
        when (getData){
            "Nasional"->{setBerita("Nas")}
            "Internasional" -> {setBerita("Inter")}
            "Ekonomi" -> {setBerita("Eko")}
            "OR" -> {setBerita("OR")}
            "Teknologi" -> {setBerita("Tekno")}
            "Hiburan" -> {setBerita("Hib")}
            "GH" -> {setBerita("GH")}
        }

    }

    private fun setBerita(namaKat :String){
        beritaPerkategoriViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            BeritaPerkategoriViewModel::class.java
        )
        if (namaKat == "Nas"){
            beritaPerkategoriViewModel.loadBeritaNasional(applicationContext)
            supportActionBar?.title = "Berita Nasional"
        }else if (namaKat == "Inter"){
            beritaPerkategoriViewModel.loadBeritaInternasional(applicationContext)
            supportActionBar?.title = "Berita Internasional"
        }else if (namaKat == "Eko"){
            beritaPerkategoriViewModel.loadBeritaEkonomi(applicationContext)
            supportActionBar?.title = "Berita Ekonomi"
        }else if (namaKat == "OR"){
            beritaPerkategoriViewModel.loadBeritaOlahRaga(applicationContext)
            supportActionBar?.title = "Berita Olah Raga"
        }else if (namaKat == "Tekno"){
            beritaPerkategoriViewModel.loadBeritaTeknologi(applicationContext)
            supportActionBar?.title = "Berita Teknologi"
        }else if (namaKat == "Hib"){
            beritaPerkategoriViewModel.loadBeritaHiburan(applicationContext)
            supportActionBar?.title = "Berita Hiburan"
        }else if (namaKat == "GH"){
            beritaPerkategoriViewModel.loadBeritaGayaHidup(applicationContext)
            supportActionBar?.title = "Berita Gaya Hidup"
        }
        beritaPerkategoriViewModel.getListBerita.observe(this, Observer {

            rv_perkategori.adapter = BeritaAdapter(applicationContext, it)
            Log.d("ResponApi", it.toString())
            showLoading(false)
        })
        rv_perkategori.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}