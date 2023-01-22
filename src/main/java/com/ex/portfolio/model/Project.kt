package com.ex.portfolio.model

import com.ex.portfolio.enums.ProjectStatus
import lombok.AllArgsConstructor
import jakarta.persistence.*

@Entity
@Table(name = "project")
@AllArgsConstructor
data class Project(
    @Id
    @Column(name = "project_id", unique = true, nullable = false, length = 20)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
    val description: String,
    @OneToOne
    val image: Image,
    val startDate : String,
    val endDate : String?,

    @Enumerated(EnumType.STRING)
    val status: ProjectStatus
) {
    constructor(name: String, description: String, image:Image, startDate: String, endDate: String?, status: ProjectStatus) :
            this(0,name, description, image, startDate, endDate, status)
    {
    }

}
