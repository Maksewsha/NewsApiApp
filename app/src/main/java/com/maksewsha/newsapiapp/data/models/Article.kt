package com.maksewsha.newsapiapp.data.models

data class Article(
    var source: SourceProp?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?
)