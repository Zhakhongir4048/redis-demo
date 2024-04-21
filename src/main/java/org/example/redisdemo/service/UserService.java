package org.example.redisdemo.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.redisdemo.dao.User;
import org.example.redisdemo.repository.UserRedisRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRedisRepository userRepository;

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
