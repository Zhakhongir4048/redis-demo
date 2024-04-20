package org.example.redisdemo.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "users", timeToLive = 24 * 3600)
public class User implements Serializable {

    @Id
    private String hashKey;
    private String username;
    private String email;

    public User() {
    }

    public User(String hashKey, String username, String email) {
        this.hashKey = hashKey;
        this.username = username;
        this.email = email;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
