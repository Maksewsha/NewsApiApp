package com.maksewsha.newsapiapp.presentation.utils

import com.maksewsha.newsapiapp.domain.models.AnswerDomain
import com.maksewsha.newsapiapp.domain.utils.EntityMapper
import com.maksewsha.newsapiapp.presentation.models.AnswerPresentation
import com.maksewsha.newsapiapp.presentation.models.ArticlePresentation
import com.maksewsha.newsapiapp.presentation.models.ArticlesRespPresentation
import com.maksewsha.newsapiapp.presentation.models.SourcePropPresentation

class PresentationMapper : EntityMapper<AnswerPresentation, AnswerDomain> {
    override fun toEntity(from: AnswerDomain): AnswerPresentation = when (from) {
        is AnswerDomain.Success -> {
            AnswerPresentation.Success(
                ArticlesRespPresentation(
                    status = from.data.status,
                    totalResults = from.data.totalResults,
                    articles = from.data.articles!!.map {
                        ArticlePresentation(
                            SourcePropPresentation(it.source!!.id, it.source!!.name),
                            it.author,
                            it.title,
                            it.description,
                            it.url,
                            it.urlToImage,
                            it.publishedAt,
                            it.content
                        )
                    })
            )
        }
        is AnswerDomain.Fail -> {
            AnswerPresentation.Fail(from.errorMessage)
        }
    }

    override fun fromEntity(to: AnswerPresentation): AnswerDomain {
        TODO("Not yet implemented")
    }
}