package com.suslanium.mvpapp.presentation

import com.suslanium.mvpapp.domain.entity.FormatResult
import com.suslanium.mvpapp.domain.usecase.FormatPhoneUseCase

class PhonePresenter(
    private val phoneFormatUseCase: FormatPhoneUseCase = FormatPhoneUseCase(),
    private var phoneScreen: PhoneScreen?
) {

    fun onDestroy() {
        phoneScreen = null
    }

    fun formatPhone(phone: String) {
        when (val result = phoneFormatUseCase(phone)) {
            FormatResult.Error -> phoneScreen?.showPhoneFormatError()
            is FormatResult.Phone -> phoneScreen?.setPhoneText(result.phone)
        }
    }

}