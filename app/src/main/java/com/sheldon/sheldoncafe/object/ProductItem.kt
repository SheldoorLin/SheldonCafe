package com.sheldon.sheldoncafe.`object`

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductItem(

    @Json(name = "image") val image: String,

    val name: String,

    val price: Int

):Parcelable