package com.crudproejct.gensparkproject.service;

import com.crudproejct.gensparkproject.exception.UserNotFoundException;
import com.crudproejct.gensparkproject.model.Card;
import com.crudproejct.gensparkproject.repository.CardRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class CardService {
    private final CardRepo cardRepo;
    @Autowired
    public CardService(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public Card addCard(Card card) {
        card.setCardCode(UUID.randomUUID().toString());
        return cardRepo.save(card);
    }

    public List<Card> findAllCards() {
        return cardRepo.findAll();
    }

    public Card updateCard(Card card) {
        return cardRepo.save(card);
    }

    public Card findCardById(Long id) {
        return cardRepo.findCardById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public void deleteCard(Card card) {
        cardRepo.delete(card);
    }
}
