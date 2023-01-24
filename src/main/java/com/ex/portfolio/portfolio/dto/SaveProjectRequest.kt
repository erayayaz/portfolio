package com.ex.portfolio.portfolio.dto

import com.ex.portfolio.portfolio.enums.ProjectStatus
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.io.File

data class SaveProjectRequest(
    val name: String,
    val description: String,
    val image: File,
    val startDate: String?,
    val endDate: String?,

    @Enumerated(value = EnumType.STRING)
    val status: ProjectStatus
) {}
