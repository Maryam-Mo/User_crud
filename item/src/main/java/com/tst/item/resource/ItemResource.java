package com.tst.item.resource;

import com.tst.commons.exceptions.DuplicateException;
import com.tst.item.repository.Item;
import com.tst.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
@RestController
@RequestMapping("/api/item")
public class ItemResource {
    @Autowired private ItemService itemService;

    @PostMapping("/create")
    public Item create(@RequestBody Item item) throws DuplicateException {
        return itemService.create(item);
    }

    @PostMapping("/update")
    public Item update(@RequestBody Item item) throws DuplicateException {
        return itemService.update(item);
    }

    @GetMapping("/findAll")
    public List<Item> findAll() {
        return itemService.findAll();
    }
}
