package com.suslanium.mvpapp.domain.entity

sealed interface FormatResult {

    data class Phone(val phone: String) : FormatResult

    data object Error : FormatResult

}