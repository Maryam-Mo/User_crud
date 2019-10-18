package com.tst.user.service;

import com.tst.commons.exceptions.DuplicateException;
import com.tst.commons.models.SearchRequest;
import com.tst.user.repository.User;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/29/19.
 */
public interface UserService {
    User create(User user) throws DuplicateException;
    User update(User savedUser) throws DuplicateException;
    List<User> findAll(SearchRequest searchRequest);
    void delete(String id);
    long count();
    User validate(String username, String password) throws DuplicateException;
}
