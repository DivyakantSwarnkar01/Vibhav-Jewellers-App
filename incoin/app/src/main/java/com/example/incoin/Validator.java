package com.example.incoin;


public class Validator {
    private String name;
    private String publicKey;

    // Constructor
    public Validator(String name, String publicKey) {
        this.name = name;
        this.publicKey = publicKey;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    // Setter methods (Optional, if needed)
    public void setName(String name) {
        this.name = name;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}

