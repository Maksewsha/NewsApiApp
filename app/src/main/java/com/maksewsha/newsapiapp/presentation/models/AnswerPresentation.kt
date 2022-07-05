package com.maksewsha.newsapiapp.presentation.models

sealed class AnswerPresentation {
    class Success(val data: ArticlesRespPresentation): AnswerPresentation()
    class Fail(val errorMessage: String): AnswerPresentation()
}