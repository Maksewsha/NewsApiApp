package com.maksewsha.newsapiapp.domain.models

data class ArticlesRespDomain(
    var status: String?,
    var totalResults: Int?,
    var articles: List<ArticleDomain>?
)