package com.maksewsha.newsapiapp.domain.models


data class ArticleDomain(
    var source: SourcePropDomain?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
)