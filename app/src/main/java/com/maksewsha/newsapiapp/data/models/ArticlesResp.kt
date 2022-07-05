package com.maksewsha.newsapiapp.data.models

import com.google.gson.annotations.SerializedName

data class ArticlesResp(
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?,
    @SerializedName("articles")
    var articles: List<Article>?
)