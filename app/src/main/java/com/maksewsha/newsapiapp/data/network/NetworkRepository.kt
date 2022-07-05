package com.maksewsha.newsapiapp.data.network

import android.util.Log
import com.maksewsha.newsapiapp.data.DataMapper
import com.maksewsha.newsapiapp.data.models.NetworkAnswer
import com.maksewsha.newsapiapp.domain.models.AnswerDomain

class NetworkRepository(private val retrofitService: RetrofitService) {

    private val dataMapper = DataMapper()

    fun getEverything(news:String): AnswerDomain{
        val response = retrofitService.getEverything(news).execute()
        Log.d("tag", response.body().toString())
        return if (response.isSuccessful && response.code() < 400){
            dataMapper.toEntity(NetworkAnswer.Success(response.body()!!))
        } else {
            dataMapper.toEntity(NetworkAnswer.Fail(response.message()))
        }
    }
}