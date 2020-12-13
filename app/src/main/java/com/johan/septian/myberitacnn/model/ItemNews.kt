package com.johan.septian.myberitacnn.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemNews(

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("waktu")
    val waktu: String? = null,

    @field:SerializedName("judul")
    val judul: String? = null,

    @field:SerializedName("tipe")
    val tipe: String? = null,

    @field:SerializedName("poster")
    val poster: String? = null
) : Parcelable
