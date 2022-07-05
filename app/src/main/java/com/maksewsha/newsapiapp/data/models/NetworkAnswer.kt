package com.maksewsha.newsapiapp.data.models

sealed class NetworkAnswer {
    class Success(val data: ArticlesResp): NetworkAnswer()
    class Fail(val errorMessage: String): NetworkAnswer()
}