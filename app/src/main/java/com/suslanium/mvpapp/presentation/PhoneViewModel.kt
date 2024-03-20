package com.suslanium.mvpapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suslanium.mvpapp.domain.entity.FormatResult
import com.suslanium.mvpapp.domain.usecase.FormatPhoneUseCase

class PhoneViewModel(
    private val formatPhoneUseCase: FormatPhoneUseCase = FormatPhoneUseCase()
) : ViewModel() {

    private val _formatResult: MutableLiveData<FormatResult> = MutableLiveData()
    val formatResult: LiveData<FormatResult>
        get() = _formatResult

    fun formatPhone(phone: String) {
        _formatResult.value = formatPhoneUseCase(phone)
    }

}