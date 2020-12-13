package com.johan.septian.myberitacnn.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemDetailNews (
    @field:SerializedName("body")
    val body: String? = null,

    @field:SerializedName("judul")
    val judul: String? = null,

    @field:SerializedName("poster")
    val poster: String? = null
        ):Parcelable