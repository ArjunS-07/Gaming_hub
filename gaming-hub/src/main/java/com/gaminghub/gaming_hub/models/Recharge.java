package com.gaminghub.gaming_hub.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "recharges")
public class Recharge {

    @Id
    private String id;

    private String memberId;  // Reference to Member _id
    private double amount;
    private LocalDateTime dateTime;

    public Recharge() {}

    public Recharge(String memberId, double amount, LocalDateTime dateTime) {
        this.memberId = memberId;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
