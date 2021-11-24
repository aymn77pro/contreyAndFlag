package com.example.contreyandflag.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

import retrofit2.http.GET

private const val BASE_URL =
    "https://countriesnow.space"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface FlagApiService {
    @GET("api/v0.1/countries/flag/images")
  suspend fun getPhotos(): arraylist
}
object FlagApi {
    val retrofitService : FlagApiService by lazy {
        retrofit.create(FlagApiService::class.java)
    }
}