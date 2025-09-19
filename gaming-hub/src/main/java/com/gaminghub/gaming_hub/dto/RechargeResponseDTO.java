package com.gaminghub.gaming_hub.dto;

import java.time.LocalDateTime;

public class RechargeResponseDTO {
    private String id;
    private String memberId;
    private double amount;
    private LocalDateTime dateTime;

    public RechargeResponseDTO() {}

    public RechargeResponseDTO(String id, String memberId, double amount, LocalDateTime dateTime) {
        this.id = id;
        this.memberId = memberId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
