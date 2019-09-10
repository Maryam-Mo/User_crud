package com.tst.user.service;

import com.tst.user.repository.User;
import com.tst.user.repository.UserRepository;
import com.tst.srv.commons.exceptions.DuplicateException;
import com.tst.srv.commons.exceptions.HmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/29/19.
 */
@Service
class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordEncoder getPasswordEncoder() {
        if (passwordEncoder == null) {
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }

    @Override
    public User create(User user) throws DuplicateException {
        if (hasDuplicate(user)) {
            throw new DuplicateException("User already exists!");
        }
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) throws DuplicateException {
        User recievedUser = findById(user.getId());
        if(!recievedUser.getPassword().equals(user.getPassword())){
            user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        }
        if (hasDuplicate(user)) {
            throw new DuplicateException("User already exists!");
        }
        return userRepository.save(user);
    }

    private User findById(String id) {
        Optional<User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.get() != null) {
            userRepository.delete(user.get());
        }
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public User validate(String username, String password) throws HmsException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(!userOptional.isPresent() || !getPasswordEncoder().matches(password, userOptional.get().getPassword())) {
            throw new HmsException("Username/Password is invalid!");
        }
        return userOptional.get();
    }

    private boolean hasDuplicate(User user) {
        User duplicate = userRepository.findByUsernameIgnoreCase(user.getUsername());
        return duplicate != null && !duplicate.getId().equalsIgnoreCase(user.getId());
    }
}
