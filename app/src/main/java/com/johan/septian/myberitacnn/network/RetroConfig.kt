package com.johan.septian.myberitacnn.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfig {
    companion object Factory{
        fun getRetrofit() : NewsService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.news.developeridn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NewsService::class.java)

        }
    }
}