package com.johan.septian.myberitacnn.fragment

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johan.septian.myberitacnn.model.Berita
import com.johan.septian.myberitacnn.model.ItemNews
import com.johan.septian.myberitacnn.network.RetroConfig
import retrofit2.Call
import retrofit2.Response

class BeritaPerkategoriViewModel : ViewModel() {

    private val listBerita : MutableLiveData<List<ItemNews>> = MutableLiveData()

    fun loadBeritaNasional(context: Context?){
        RetroConfig.getRetrofit().getDataNasional().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    fun loadBeritaInternasional(context: Context?){
        RetroConfig.getRetrofit().getDataInternasional().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    fun loadBeritaEkonomi(context: Context?){
        RetroConfig.getRetrofit().getDataEkonomi().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    fun loadBeritaOlahRaga(context: Context?){
        RetroConfig.getRetrofit().getDataOlahraga().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    fun loadBeritaTeknologi(context: Context?){
        RetroConfig.getRetrofit().getDataTeknologi().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    fun loadBeritaHiburan(context: Context?){
        RetroConfig.getRetrofit().getDataHiburan().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    fun loadBeritaGayaHidup(context: Context?){
        RetroConfig.getRetrofit().getDataGayaHidup().enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    val getListBerita : LiveData<List<ItemNews>> = listBerita

}