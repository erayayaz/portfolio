package com.ex.portfolio.portfolio.repository;

import com.ex.portfolio.portfolio.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Optional<Contact> findOne();
}
