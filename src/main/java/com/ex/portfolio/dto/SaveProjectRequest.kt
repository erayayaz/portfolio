package com.ex.portfolio.dto

import com.ex.portfolio.enums.ProjectStatus
import com.ex.portfolio.model.Image
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.io.File

data class SaveProjectRequest(
    val name: String,
    val description: String,
    val image: File,
    val startDate : String?,
    val endDate : String?,

    @Enumerated(value = EnumType.STRING)
    val status: ProjectStatus
) {}
