package com.gaminghub.gaming_hub.dto;

public class MemberRequestDTO {
    private String name;
    private String phone;
    private double balance;

    public MemberRequestDTO() {}

    public MemberRequestDTO(String name, String phone, double balance) {
        this.name = name;
        this.phone = phone;
        this.balance = balance;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
