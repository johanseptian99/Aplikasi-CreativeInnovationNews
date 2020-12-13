package com.johan.septian.myberitacnn.fragment

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johan.septian.myberitacnn.model.DetailBerita
import com.johan.septian.myberitacnn.model.ItemDetailNews
import com.johan.septian.myberitacnn.network.RetroConfig
import retrofit2.Call
import retrofit2.Response

class DetailViewModel: ViewModel() {
    private val listDetailBerita : MutableLiveData<List<ItemDetailNews>> = MutableLiveData()

    fun loadDetailBerita(context: Context, url:String?){
        RetroConfig.getRetrofit().getDetailBerita(url).enqueue(object : retrofit2.Callback<DetailBerita>{
            override fun onFailure(call: Call<DetailBerita>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DetailBerita>, response: Response<DetailBerita>) {
                if(response.body() != null){
                    listDetailBerita.postValue(response.body()?.data)
                }
            }
        })
    }

    val getListDetailBerita : LiveData<List<ItemDetailNews>> = listDetailBerita
}