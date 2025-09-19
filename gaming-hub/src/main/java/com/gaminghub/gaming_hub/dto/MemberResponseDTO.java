package com.gaminghub.gaming_hub.dto;

public class MemberResponseDTO {
    private String id;
    private String name;
    private String phone;
    private double balance;

    public MemberResponseDTO() {}

    public MemberResponseDTO(String id, String name, String phone, double balance) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.balance = balance;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
