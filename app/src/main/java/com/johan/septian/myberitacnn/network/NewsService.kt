package com.johan.septian.myberitacnn.network

import com.johan.septian.myberitacnn.model.Berita
import com.johan.septian.myberitacnn.model.DetailBerita
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/")
    fun getBeritaRandom() : Call<Berita>

    //getDataNasional
    @GET("nasional")
    fun getDataNasional() : Call<Berita>

    //getDataInternasional
    @GET("internasional")
    fun getDataInternasional() : Call<Berita>

    //getDataEkonomi
    @GET("ekonomi")
    fun getDataEkonomi() : Call<Berita>

    //getDataOlahraga
    @GET("olahraga")
    fun getDataOlahraga() : Call<Berita>

    //getDataTeknologi
    @GET("teknologi")
    fun getDataTeknologi() : Call<Berita>

    //getDataHiburan
    @GET("hiburan")
    fun getDataHiburan() : Call<Berita>

    //getDataGayaHidup
    @GET("gaya-hidup")
    fun getDataGayaHidup() : Call<Berita>

    @GET("search/")
    fun getSearchBerita(
        @Query("q") query: String?) : Call<Berita>

    @GET("detail/")
    fun getDetailBerita(
        @Query("url") url: String?) : Call<DetailBerita>
}