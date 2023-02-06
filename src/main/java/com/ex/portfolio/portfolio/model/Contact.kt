package com.ex.portfolio.portfolio.model

import jakarta.persistence.*
import lombok.AllArgsConstructor

@Entity
@Table(name = "contact")
@AllArgsConstructor
data class Contact(
    @Id
    @Column(name = "contact_id", unique = true, nullable = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val email: String,
    val instaUrl: String,
    val linkedInUrl: String,
    val twitterUrl: String,
)
