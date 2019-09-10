package com.tst.item.service;

import com.tst.item.repository.Item;
import com.tst.item.repository.ItemRepository;
import com.tst.srv.commons.exceptions.DuplicateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceIt {
    @Autowired private ItemService itemService;
    @Autowired private ItemRepository itemRepository;

    @Test
    public void create() throws DuplicateException {
        Item item = getItem();
        Item savedItem = itemService.create(item);
        assertNotNull(savedItem);
        assertNotNull(item.getId());
        assertEquals(item.getName(), savedItem.getName());
        assertEquals(item.getQuantity(), savedItem.getQuantity(), 0);
        assertEquals(item.getPrice(), savedItem.getPrice(), 0);
        removeTest(item);
    }

    @Test
    public void update() throws DuplicateException {
        Item savedItem = itemService.create(getItem());
        savedItem.setPrice(2000);
        Item updatedItem = itemService.update(savedItem);
        assertNotNull(updatedItem);
        assertNotNull(updatedItem.getId());
        assertEquals(updatedItem.getName(), savedItem.getName());
        assertEquals(updatedItem.getPrice(), savedItem.getPrice(), 0);
        assertEquals(updatedItem.getQuantity(), savedItem.getQuantity(), 0);
        removeTest(savedItem);
        removeTest(updatedItem);
    }

    @Test
    public void find() throws DuplicateException {
        Item savedItem = itemService.create(getItem());
        List<Item> items = itemService.findAll();
        Item item = items.get(0);
        assertNotNull(item);
        assertEquals(1, items.size());
        assertEquals(item.getId() , savedItem.getId());
        assertEquals(item.getName() , savedItem.getName());
        assertEquals(item.getQuantity(), savedItem.getQuantity(), 0);
        assertEquals(item.getPrice(), savedItem.getPrice(), 0);
        removeTest(savedItem);
    }


    private void removeTest(Item item){
        Item receivedItem = item;
        Item duplicateItem = itemRepository.findByNameIgnoreCase(receivedItem.getName());
        if (duplicateItem != null) {
            itemRepository.deleteById(duplicateItem.getId());
        }
    }

    private Item getItem() {
        Item item= new Item();
        item.setName("item");
        item.setQuantity(10);
        item.setPrice(1000);
        return item;
    }
}
