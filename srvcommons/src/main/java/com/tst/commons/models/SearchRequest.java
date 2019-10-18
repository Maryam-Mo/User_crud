package com.tst.commons.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 10/17/19.
 */
@Data
@AllArgsConstructor
public class SearchRequest {

    private int pageSize;
    private int pageNo;
    private String sortBy;
    private boolean descending = true;

}
