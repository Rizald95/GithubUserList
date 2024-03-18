package com.example.githubuserlist.data.api

import com.example.githubuserlist.BuildConfig
import com.example.githubuserlist.data.model.ItemsItem
import com.example.githubuserlist.data.model.DetailGithubUser
import com.example.githubuserlist.data.model.ResponseGithubUser

import retrofit2.Call
import retrofit2.http.HTTP
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface ApiService {
    @JvmSuppressWildcards
    @GET("users")
    suspend fun getUser(
        @Header("Authorization")
        authorization: String = BuildConfig.TOKEN
    ): MutableList<ItemsItem>

    @JvmSuppressWildcards
    @GET("users/{username}")
    suspend fun getDetailUser(
        @Path("username") username: String,
        @Header("Authorization")
        authorization: String = BuildConfig.TOKEN
    ): DetailGithubUser

    @JvmSuppressWildcards
    @GET("/users/{username}/followers")
    suspend fun getFollowers(
        @Path("username") username: String,
        @Header("Authorization")
        authorization: String = BuildConfig.TOKEN
    ): MutableList<ItemsItem>

    @JvmSuppressWildcards
    @GET("/users/{username}/following")
    suspend fun getFollowing(
        @Path("username") username: String,
        @Header("Authorization")
        authorization: String = BuildConfig.TOKEN
    ): MutableList<ItemsItem>

    @JvmSuppressWildcards
    @GET("search/users")
    suspend fun getSearchUser(
        @QueryMap params: Map<String, Any>,
        @Header("Authorization")
        authorization: String = BuildConfig.TOKEN
    ): ResponseGithubUser
}