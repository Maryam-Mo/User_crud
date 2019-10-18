package com.tst.user.resource;

import com.tst.commons.exceptions.DuplicateException;
import com.tst.commons.models.SearchRequest;
import com.tst.user.repository.User;
import com.tst.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/30/19.
 */
@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) throws DuplicateException {
        return userService.create(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) throws DuplicateException {
        return userService.update(user);
    }

    @PostMapping("/findAll")
    public List<User> findAll(@RequestBody SearchRequest searchRequest) {
        return userService.findAll(searchRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String id) {
        userService.delete(id);
    }

    @GetMapping("/validate")
    public User validate(@RequestParam String username, @RequestParam String password) throws DuplicateException {
        return userService.validate(username, password);
    }
}
