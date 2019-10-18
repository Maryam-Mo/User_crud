package com.tst.item.service;

import com.tst.commons.exceptions.DuplicateException;
import com.tst.item.repository.Item;
import com.tst.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired private ItemRepository itemRepository;

    @Override
    public Item create(Item item) throws DuplicateException {
        if (hasDuplicate(item)) {
            throw new DuplicateException("Item already exists!");
        }
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) throws DuplicateException {
        if (hasDuplicate(item)) {
            throw new DuplicateException("Item already exists!");
        }
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    private boolean hasDuplicate(Item item) {
        Item duplicate = itemRepository.findByNameIgnoreCase(item.getName());
        return duplicate != null && !duplicate.getId().equalsIgnoreCase(item.getId());
    }


}
