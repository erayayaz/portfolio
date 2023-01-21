package com.ex.portfolio.model

import jakarta.persistence.*

@Entity
data class Project(
    @Id
    @Column(name = "news_id", unique = true, nullable = false, length = 20)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Int?,
)
