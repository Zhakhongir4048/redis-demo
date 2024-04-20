package org.example.redisdemo.controller;

import org.example.redisdemo.dao.User;
import org.example.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "users", unless = "#result.username == null")
    public User getUserById(@PathVariable String id) {
        return userService.findByHashKey(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "users")
    public void remove(@PathVariable String id) {
        userService.deleteById(id);
    }
}
