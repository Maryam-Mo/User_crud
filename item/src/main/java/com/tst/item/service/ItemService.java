package com.tst.item.service;

import com.tst.item.repository.Item;
import com.tst.srv.commons.exceptions.DuplicateException;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
public interface ItemService {
    Item create(Item item) throws DuplicateException;
    Item update(Item savedItem) throws DuplicateException;
    List<Item> findAll();
}
