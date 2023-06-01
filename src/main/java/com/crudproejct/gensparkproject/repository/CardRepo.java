package com.crudproejct.gensparkproject.repository;

import com.crudproejct.gensparkproject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepo extends JpaRepository<Card, Long> {
    Optional<Card> findCardById(Long id);
}
