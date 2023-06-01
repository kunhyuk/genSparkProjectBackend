package com.crudproejct.gensparkproject.controller;

import com.crudproejct.gensparkproject.model.Card;
import com.crudproejct.gensparkproject.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/card")
public class CardResource {
    private final CardService cardService;

    public CardResource(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Card>> getAllCards () {
        List<Card> cards = cardService.findAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK );
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Card> getCardById (@PathVariable("id") Long id) {
        Card card = cardService.findCardById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody Card card) {
        Card newCard = cardService.addCard(card);
        return new ResponseEntity<>(newCard, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Card> updateCard(@RequestBody Card card) {
        Card newCard = cardService.addCard(card);
        return new ResponseEntity<>(newCard, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCard(@PathVariable("id") Long id) {
        Card card = cardService.findCardById(id);
        cardService.deleteCard(card);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
