package com.tst.user.service;

import com.tst.srv.commons.exceptions.DuplicateException;
import com.tst.user.repository.User;
import com.tst.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/29/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIt {
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;

    @Test
    public void create() throws DuplicateException {
        User user = getUser();
        User savedUser = userService.create(user);
        assertNotNull(savedUser);
        assertNotNull(user.getId());
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getLastName(), savedUser.getLastName());
        assertEquals(user.getUsername(), savedUser.getUsername());
        assertEquals(user.getPassword(), savedUser.getPassword());
        removeTest(user);
    }

    @Test
    public void update() throws DuplicateException {
        User savedUser = userService.create(getUser());
        savedUser.setFirstName("Maryam");
        User updatedUser = userService.update(savedUser);
        assertNotNull(updatedUser);
        assertNotNull(updatedUser.getId());
        assertEquals(updatedUser.getFirstName(), savedUser.getFirstName());
        assertEquals(updatedUser.getLastName(), savedUser.getLastName());
        assertEquals(updatedUser.getUsername(), savedUser.getUsername());
        assertEquals(updatedUser.getPassword(), savedUser.getPassword());
        removeTest(savedUser);
        removeTest(updatedUser);
    }

    @Test
    public void find() throws DuplicateException {
        User savedUser = userService.create(getUser());
        List<User> users = userService.findAll();
        User user = users.get(0);
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user.getId() , savedUser.getId());
        assertEquals(user.getUsername() , savedUser.getUsername());
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getLastName(), savedUser.getLastName());
        assertEquals(user.getPassword(), savedUser.getPassword());
        removeTest(savedUser);
    }

    @Test
    public void delete() throws DuplicateException {
        User savedUser = userService.create(getUser());
        List<User> users = userService.findAll();
        assertNotNull(users);
        assertEquals(1, users.size());
        userService.delete(savedUser.getId());
        List<User> usersAfterDeletetion = userService.findAll();
        assertEquals(0, usersAfterDeletetion.size());
    }

    private void removeTest(User user){
        User receivedUser = user;
        User duplicateUser = userRepository.findByUsernameIgnoreCase(receivedUser.getUsername());
        if (duplicateUser != null) {
            userRepository.deleteById(duplicateUser.getId());
        }
    }

    private User getUser() {
        User user= new User();
        user.setUsername("user");
        user.setFirstName("Mary");
        user.setLastName("Moein");
        return user;
    }
}
