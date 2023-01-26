package com.ex.portfolio.portfolio.dto

import com.ex.portfolio.portfolio.enums.ProjectStatus
import com.ex.portfolio.portfolio.model.Image
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class SaveProjectRequest(
    val name: String,
    val description: String,
    val image: Image,
    val startDate: String?,
    val endDate: String?,

    @Enumerated(value = EnumType.STRING)
    val status: ProjectStatus
) {}
