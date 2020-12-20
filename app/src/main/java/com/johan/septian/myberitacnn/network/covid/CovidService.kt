package com.johan.septian.myberitacnn.network.covid

import com.johan.septian.myberitacnn.model.ResponseCovid
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {
    //getDataStatistikCovid
    @GET("api/provinsi/")
    fun getDataCovid(): Call<ResponseCovid>
}