package com.ex.portfolio.portfolio.repository;

import com.ex.portfolio.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByName(String name);
}
