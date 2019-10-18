package com.tst.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/29/19.
 */
public interface UserRepository extends MongoRepository<User, String>, CustomUserRepository {
    User findByUsernameIgnoreCase(String username);
    Optional<User> findByUsername(String username);
}
