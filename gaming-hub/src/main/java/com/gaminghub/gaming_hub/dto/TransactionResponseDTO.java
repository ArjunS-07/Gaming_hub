package com.gaminghub.gaming_hub.dto;

import java.time.LocalDateTime;

public class TransactionResponseDTO {
    private String id;
    private String memberId;
    private String gameId;
    private Double amount;
    private LocalDateTime dateTime;

    public TransactionResponseDTO() {}

    public TransactionResponseDTO(String id, String memberId, String gameId, Double amount, LocalDateTime dateTime) {
        this.id = id;
        this.memberId = memberId;
        this.gameId = gameId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getGameId() { return gameId; }
    public void setGameId(String gameId) { this.gameId = gameId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
