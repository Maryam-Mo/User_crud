package com.tst.item.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 9/9/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;
}
