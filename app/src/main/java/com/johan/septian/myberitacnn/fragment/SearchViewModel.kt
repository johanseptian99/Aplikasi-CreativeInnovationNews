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

class SearchViewModel : ViewModel() {
    private val listSearchBerita : MutableLiveData<List<ItemNews>> = MutableLiveData()

    fun loadSearchBerita(context: Context, query:String?){
        RetroConfig.getRetrofit().getSearchBerita(query).enqueue(object : retrofit2.Callback<Berita>{
            override fun onFailure(call: Call<Berita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Berita>, response: Response<Berita>) {
                if(response.body() != null){
                    listSearchBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    val getListSearchBerita : LiveData<List<ItemNews>> = listSearchBerita
}