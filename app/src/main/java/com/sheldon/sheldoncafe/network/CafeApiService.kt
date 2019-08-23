package com.sheldon.sheldoncafe.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.appworks-school.tw/api/1.0/"
// https://latte-ccbd9.firebaseio.com


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

interface CafeApiService{

}
object CafeApi {
    val retrofitService: CafeApiService by lazy { retrofit.create(CafeApiService::class.java) }
}