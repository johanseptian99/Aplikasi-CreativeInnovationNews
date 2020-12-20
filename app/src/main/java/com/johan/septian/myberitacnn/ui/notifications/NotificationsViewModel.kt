package com.johan.septian.myberitacnn.ui.notifications

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johan.septian.myberitacnn.model.DataCovid
import com.johan.septian.myberitacnn.model.ResponseCovid
import com.johan.septian.myberitacnn.network.covid.RetroConfigCovid
import retrofit2.Call
import retrofit2.Response

class NotificationsViewModel : ViewModel() {

    private val listCovid : MutableLiveData<List<DataCovid>> = MutableLiveData()

    fun loadCovid(context: Context?){
        RetroConfigCovid.getRetrofit().getDataCovid().enqueue(object : retrofit2.Callback<ResponseCovid>{
            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseCovid>, response: Response<ResponseCovid>) {
                if(response.body() != null){
                    listCovid.postValue(response.body()?.data)
                }
            }
        })
    }

    val getListCovid : LiveData<List<DataCovid>> = listCovid
}