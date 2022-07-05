package com.maksewsha.newsapiapp.data

import com.maksewsha.newsapiapp.data.models.ArticlesResp
import com.maksewsha.newsapiapp.data.models.NetworkAnswer
import com.maksewsha.newsapiapp.domain.models.AnswerDomain
import com.maksewsha.newsapiapp.domain.models.ArticleDomain
import com.maksewsha.newsapiapp.domain.models.ArticlesRespDomain
import com.maksewsha.newsapiapp.domain.models.SourcePropDomain
import com.maksewsha.newsapiapp.domain.utils.EntityMapper

class DataMapper : EntityMapper<AnswerDomain, NetworkAnswer> {
    override fun toEntity(from: NetworkAnswer): AnswerDomain = when (from) {
        is NetworkAnswer.Success -> {
            AnswerDomain.Success(
                ArticlesRespDomain(
                    status = from.data.status,
                    totalResults = from.data.totalResults,
                    articles = from.data.articles!!.map {
                        ArticleDomain(
                            source = SourcePropDomain(it.source!!.id, it.source!!.name),
                            author = it.author,
                            title = it.title,
                            description = it.description,
                            url = it.url,
                            urlToImage = it.urlToImage,
                            publishedAt = it.publishedAt,
                            content = it.content
                        )
                    })
            )
        }
        is NetworkAnswer.Fail -> {
            AnswerDomain.Fail(
                errorMessage = from.errorMessage
            )
        }
    }

    override fun fromEntity(to: AnswerDomain): NetworkAnswer {
        TODO("Not yet implemented")
    }
}