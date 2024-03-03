package com.forum.units;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void autoGenerateId() {
        
        throw new UnsupportedOperationException("Unimplemented method 'autoGenerateId'");
    }

    public void setCreated() {
        
        throw new UnsupportedOperationException("Unimplemented method 'setCreated'");
    }
}

