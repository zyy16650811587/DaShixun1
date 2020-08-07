package com.example.dashixun1;

import com.google.gson.JsonElement;

import java.io.Serializable;

public class JsonBean implements Serializable {
    boolean success;
    JsonElement Data;
    String message;
    int expiration;



    public JsonElement getData() {
        return Data;
    }

    public void setData(JsonElement data) {
        Data = data;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
