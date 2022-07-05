package com.maksewsha.newsapiapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.newsapiapp.data.network.NetworkRepository
import com.maksewsha.newsapiapp.data.network.RetrofitService
import com.maksewsha.newsapiapp.domain.usecases.GetEverythingUseCase

class NewsViewModelFactory: ViewModelProvider.Factory {

    private val retrofitService = RetrofitService.getInstance()

    private val networkRepository = NetworkRepository(retrofitService)

    private val getEverythingUseCase = GetEverythingUseCase(networkRepository)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(getEverythingUseCase) as T
    }
}