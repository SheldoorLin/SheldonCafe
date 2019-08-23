package com.sheldon.sheldoncafe.`object`

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


data class Order(

    @Json(name = "") val id: String,

    val title: String


)