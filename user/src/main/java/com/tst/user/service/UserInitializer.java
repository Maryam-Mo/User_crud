package com.tst.user.service;

import com.tst.srv.commons.exceptions.DuplicateException;
import com.tst.user.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/30/19.
 */
@Profile("!dev")
@Service
public class UserInitializer {
    @Autowired private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordEncoder getPasswordEncoder() {
        if (passwordEncoder == null) {
            passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }

    public void start() throws DuplicateException {
        if (userService.count() == 0) {
            User defaultUser = new User();
            defaultUser.setFirstName("Super");
            defaultUser.setLastName("Admin");
            defaultUser.setUsername("admin");
            defaultUser.setPassword("admin");
            userService.create(defaultUser);
        }
    }

}
