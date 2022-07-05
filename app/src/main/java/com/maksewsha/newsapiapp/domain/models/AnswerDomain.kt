package com.maksewsha.newsapiapp.domain.models

sealed class AnswerDomain {
    class Success(val data: ArticlesRespDomain): AnswerDomain()
    class Fail(val errorMessage: String): AnswerDomain()
}