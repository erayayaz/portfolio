package com.ex.portfolio.dto

import com.ex.portfolio.portfolio.enums.ProjectStatus
import com.ex.portfolio.portfolio.model.Image

data class ProjectDto(
    val id: Int?,
    val name: String,
    val description: String,
    val image: Image,
    val startDate: String?,
    val endDate: String?,
    val status: ProjectStatus?
)
