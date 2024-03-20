package com.suslanium.mvpapp.domain.usecase

import com.suslanium.mvpapp.domain.entity.FormatResult

class FormatPhoneUseCase {

    private val phoneRegex =
        Regex("(?:\\+7|8)\\s?\\(?([0-9]{3})\\)?\\s?([0-9]{3})[-\\s]?([0-9]{2})[-\\s]?([0-9]{2})")

    operator fun invoke(input: String): FormatResult {
        val match = phoneRegex.matchEntire(input) ?: return FormatResult.Error

        return FormatResult.Phone("+7 (${match.groupValues[1]}) ${match.groupValues[2]} ${match.groupValues[3]} ${match.groupValues[4]}")
    }

}