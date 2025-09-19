package com.gaminghub.gaming_hub.dto;

import java.time.LocalDate;

public class CollectionRecordResponseDTO {
    private String id;
    private LocalDate date;
    private Double amount;

    public CollectionRecordResponseDTO() {}

    public CollectionRecordResponseDTO(String id, LocalDate date, Double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
