package com.ex.portfolio.portfolio.model

import com.ex.portfolio.portfolio.enums.ProjectStatus
import jakarta.persistence.*
import lombok.AllArgsConstructor

@Entity
@Table(name = "project")
@AllArgsConstructor
data class Project(
    @Id
    @Column(name = "project_id", unique = true, nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
    val description: String,
    val startDate: String,
    val endDate: String?,

    @OneToOne(cascade = [CascadeType.ALL])
    val image: Image?,

    @Enumerated(EnumType.STRING)
    val status: ProjectStatus
) {
    constructor(
        name: String,
        description: String,
        image: Image,
        startDate: String,
        endDate: String?,
        status: ProjectStatus
    ) : this(0, name, description, startDate, endDate, image, status)
}
