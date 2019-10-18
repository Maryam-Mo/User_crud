package com.tst.user.repository;

import com.tst.commons.models.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 10/17/19.
 */

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired private MongoOperations mongoOperations;

    @Override
    public List<User> findUsers(SearchRequest searchRequest) {
        Sort.Direction sort = searchRequest.isDescending() ? Sort.Direction.DESC : Sort.Direction.ASC;
        String sortBy = searchRequest.getSortBy() == null ? "username" : searchRequest.getSortBy();
        Pageable page = PageRequest.of(searchRequest.getPageNo()-1, searchRequest.getPageSize(), sort, sortBy);
        Query query = new Query();
        query.with(page);
        return mongoOperations.find(query, User.class);
    }

    @Override
    public long countUsers() {
        Query query = new Query();
        return mongoOperations.count(query, User.class);
    }


}
