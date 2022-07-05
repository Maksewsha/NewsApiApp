package com.maksewsha.newsapiapp.data.network

import com.maksewsha.newsapiapp.data.models.ArticlesResp
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    companion object {
        private val BASE_URL = "https://newsapi.org/"
        private var retrofit: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofit == null) {
                val retro = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofit = retro.create(RetrofitService::class.java)
            }
            return retrofit!!
        }
    }

    @GET("/v2/everything?apiKey=d6d9fa01075048f8b3cd7fdac13f8aab")
    fun getEverything(@Query("q") news: String): Call<ArticlesResp>
}