package com.tst.user.repository;

import com.tst.commons.models.SearchRequest;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 10/17/19.
 */
public interface CustomUserRepository {

    List<User> findUsers(SearchRequest searchRequest);
    long countUsers();
}
