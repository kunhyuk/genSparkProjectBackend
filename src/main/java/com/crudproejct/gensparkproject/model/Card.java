package com.crudproejct.gensparkproject.model;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String status;
    private String text;
    private String color;
    private String tags;

    @Column(nullable = false, updatable = false)
    private String cardCode;

    public Card() {
    }

    public Card(Long id, String status, String text, String color, String tags, String cardCode) {
        this.id = id;
        this.status = status;
        this.text = text;
        this.color = color;
        this.tags = tags;
        this.cardCode = cardCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", tags='" + tags + '\'' +
                ", cardCode='" + cardCode + '\'' +
                '}';
    }
}