package com.ex.portfolio.portfolio.repository;

import com.ex.portfolio.portfolio.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AboutRepository extends JpaRepository<About, Integer> {
    Optional<About> findByAboutText(String aboutText);
}
