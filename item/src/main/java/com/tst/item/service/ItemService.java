package com.tst.item.service;

import com.tst.commons.exceptions.DuplicateException;
import com.tst.item.repository.Item;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
public interface ItemService {
    Item create(Item item) throws DuplicateException, DuplicateException;
    Item update(Item savedItem) throws DuplicateException;
    List<Item> findAll();
}
