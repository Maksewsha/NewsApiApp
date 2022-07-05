package com.maksewsha.newsapiapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maksewsha.newsapiapp.domain.models.AnswerDomain
import com.maksewsha.newsapiapp.domain.usecases.GetEverythingUseCase
import com.maksewsha.newsapiapp.presentation.models.AnswerPresentation
import com.maksewsha.newsapiapp.presentation.models.ArticlesRespPresentation
import com.maksewsha.newsapiapp.presentation.utils.PresentationMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val getEverythingUseCase: GetEverythingUseCase) : ViewModel() {
    private val _news = MutableLiveData<ArticlesRespPresentation>()
    val news = _news as LiveData<ArticlesRespPresentation>

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage = _errorMessage as LiveData<String>

    private val mapper = PresentationMapper()

    fun getNews() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = mapper.toEntity(getEverythingUseCase.execute())
            when (response) {
                is AnswerPresentation.Success -> {
                    _news.postValue(response.data)
                }
                is AnswerPresentation.Fail -> {
                    _errorMessage.postValue(response.errorMessage)
                }
            }
            Log.d("tag", "ASDASDASD ${response.toString()} --- ${_news.value.toString()}")
        }
    }
}