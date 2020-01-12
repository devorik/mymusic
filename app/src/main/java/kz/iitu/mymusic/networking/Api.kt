package kz.iitu.mymusic.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private const val ENDPOINT = "https://theaudiodb.com/api/v1/json/1/"

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiClient() =
        getRetrofit().create(ApiClient::class.java)
}