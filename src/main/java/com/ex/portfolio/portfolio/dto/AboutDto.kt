package com.ex.portfolio.portfolio.dto

import lombok.NoArgsConstructor

@NoArgsConstructor
data class AboutDto(
    val aboutText: String,
) {
    constructor() : this("") {

    }
}
