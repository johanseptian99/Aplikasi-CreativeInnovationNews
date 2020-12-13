package com.johan.septian.myberitacnn.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailBerita (
    @field:SerializedName("data")
    val data: List<ItemDetailNews>,

    @field:SerializedName("status")
    val status: Int
    ):Parcelable