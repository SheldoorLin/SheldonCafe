package com.sheldon.sheldoncafe.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sheldon.sheldoncafe.`object`.Order
import com.sheldon.sheldoncafe.`object`.ProductItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://latte-ccbd9.firebaseio.com/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(MapJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(client)
    .baseUrl(BASE_URL)
    .build()


interface CafeApiService {
    @GET("items.json")
    fun getProductItems(): Deferred<List<ProductItem>>

    @GET("orders.json")
    fun getOrders(
        @Query("orderBy") orderBy: String? = "\"account\"",
        @Query("equalTo") equalTo: String? = "\"sheldon@74latte.com\""
    ): Deferred<Map<String, Order>>


}

object CafeApi {
    val retrofitService: CafeApiService by lazy { retrofit.create(CafeApiService::class.java) }
}