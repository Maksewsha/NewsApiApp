package com.maksewsha.newsapiapp.presentation.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class ArticlePresentation(
    var source: @RawValue SourcePropPresentation?,
    var author: @RawValue String?,
    var title: @RawValue String?,
    var description: @RawValue String?,
    var url: @RawValue String?,
    var urlToImage: @RawValue String?,
    var publishedAt: @RawValue String?,
    var content: @RawValue String?
): Parcelable