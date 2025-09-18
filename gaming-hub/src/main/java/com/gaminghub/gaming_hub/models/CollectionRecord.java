package com.gaminghub.gaming_hub.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "collections")
public class CollectionRecord {

    @Id
    private String id;

    private LocalDate date;
    private Double amount;

    public CollectionRecord() {}

    public CollectionRecord(LocalDate date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
