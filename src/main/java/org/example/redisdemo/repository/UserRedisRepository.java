package org.example.redisdemo.repository;

import org.example.redisdemo.dao.User;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedisRepository extends KeyValueRepository<User, String> {
}
