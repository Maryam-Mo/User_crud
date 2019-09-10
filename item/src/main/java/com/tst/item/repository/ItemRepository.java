package com.tst.item.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByNameIgnoreCase(String name);
    void deleteById(String id);
}
