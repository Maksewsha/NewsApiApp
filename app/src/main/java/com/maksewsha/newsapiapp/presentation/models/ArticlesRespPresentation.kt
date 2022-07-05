package com.maksewsha.newsapiapp.presentation.models


data class ArticlesRespPresentation(
    var status: String?,
    var totalResults: Int?,
    var articles: List<ArticlePresentation>?
)