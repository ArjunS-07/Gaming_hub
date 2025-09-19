package com.gaminghub.gaming_hub.dto;

import java.time.LocalDateTime;

public class RechargeRequestDTO {
    private String memberId;
    private double amount;
    private LocalDateTime dateTime;

    public RechargeRequestDTO() {}

    public RechargeRequestDTO(String memberId, double amount, LocalDateTime dateTime) {
        this.memberId = memberId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
