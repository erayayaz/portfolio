package com.ex.portfolio.portfolio.model

import jakarta.persistence.*
import lombok.AllArgsConstructor

@Entity
@Table(name = "about")
@AllArgsConstructor
data class About(
    @Id
    @Column(name = "about_id", unique = true, nullable = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val aboutText: String,
) {
    constructor(
        aboutText: String
    ) : this(0, aboutText)
}
