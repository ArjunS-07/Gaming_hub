package com.gaminghub.gaming_hub.dto;

public class AdminUserResponseDTO {
    private String id;
    private String username;

    public AdminUserResponseDTO() {}

    public AdminUserResponseDTO(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
