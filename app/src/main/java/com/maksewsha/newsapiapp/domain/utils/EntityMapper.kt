package com.maksewsha.newsapiapp.domain.utils

interface EntityMapper<T, F> {
    fun toEntity(from: F): T
    fun fromEntity(to: T): F
}