package com.example.githubuserlist.data.api
import retrofit2.create
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory
import  retrofit2.Retrofit

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient

import com.example.githubuserlist.BuildConfig.API_URL

object ApiConfig {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okhttp = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(25, TimeUnit.SECONDS)
        .writeTimeout(300, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okhttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubService = retrofit.create<ApiService>()
}