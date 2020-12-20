package com.johan.septian.myberitacnn.network.covid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfigCovid {
    companion object Factory{
        fun getRetrofit() : CovidService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://indonesia-covid-19.mathdro.id/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(CovidService::class.java)

        }
    }
}
