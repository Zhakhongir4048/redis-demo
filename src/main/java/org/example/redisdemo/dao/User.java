package org.example.redisdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "users", timeToLive = 24 * 3600)
public class User implements Serializable {

    @Id
    private String hashKey;
    private String username;
    private String email;
}
