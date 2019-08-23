package com.sheldon.sheldoncafe.`object`

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(

    @Json(name = "") var id: String,

    val order: Orderlist

) : Parcelable

@Parcelize
data class Orderlist(
    val account: String,
    val content: ProductItem,
    val itemCount: Int,
    val price: Int,
    val status: Int,
    val time: Long
) : Parcelable