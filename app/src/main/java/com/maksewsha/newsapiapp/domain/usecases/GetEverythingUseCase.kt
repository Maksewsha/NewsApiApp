package com.maksewsha.newsapiapp.domain.usecases

import android.util.Log
import com.maksewsha.newsapiapp.data.network.NetworkRepository
import com.maksewsha.newsapiapp.data.network.RetrofitService
import com.maksewsha.newsapiapp.domain.models.AnswerDomain

class GetEverythingUseCase(private val networkRepository: NetworkRepository) {
    fun execute() = networkRepository.getEverything()
}