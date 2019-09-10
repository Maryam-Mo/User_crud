package com.tst.user.service;

import com.tst.srv.commons.exceptions.DuplicateException;
import com.tst.srv.commons.exceptions.HmsException;
import com.tst.user.repository.User;
import org.omg.CORBA.UserException;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/29/19.
 */
public interface UserService {
    User create(User user) throws DuplicateException;
    User update(User savedUser) throws DuplicateException;
    List<User> findAll();
    void delete(String id);
    long count();
    User validate(String username, String password) throws HmsException;
}
