package com.ex.portfolio.portfolio.model

import jakarta.persistence.*
import lombok.AllArgsConstructor

@Entity
@Table(name = "image")
@AllArgsConstructor
data class Image(
    @Id
    @Column(name = "image_id", unique = true, nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val url: String?
)
