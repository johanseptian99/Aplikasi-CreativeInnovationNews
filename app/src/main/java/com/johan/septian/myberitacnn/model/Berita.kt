package com.johan.septian.myberitacnn.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Berita(
    @field:SerializedName("data")
    val data: List<ItemNews>,

    @field:SerializedName("length")
    val length: Int,

    @field:SerializedName("status")
    val status: Int
):Parcelable