package org.example.redisdemo.service;

import org.example.redisdemo.dao.User;
import org.example.redisdemo.repository.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRedisRepository userRepository;

    @Autowired
    public UserService(UserRedisRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User data) {
        return userRepository.save(data);
    }

    public User findByHashKey(String id) {
        System.out.println("called findByHashKey");
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
