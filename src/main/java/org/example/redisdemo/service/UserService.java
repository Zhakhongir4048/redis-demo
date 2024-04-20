package org.example.redisdemo.service;

import org.example.redisdemo.dao.User;
import org.example.redisdemo.repository.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRedisRepository userRepository;
    private static final String HASH_KEY = "Users";


    @Autowired
    public UserService(UserRedisRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User data) {
        return userRepository.save(data);
    }

    public User findByHashKey(String id) {
        return userRepository.findById(id).orElseThrow();
    }
}
