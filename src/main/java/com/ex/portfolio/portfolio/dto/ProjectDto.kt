package com.ex.portfolio.dto

import com.ex.portfolio.portfolio.enums.ProjectStatus

data class ProjectDto(
    val id: Int?,
    val name: String,
    val description: String,
    val startDate: String?,
    val endDate: String?,
    val status: ProjectStatus?
)
