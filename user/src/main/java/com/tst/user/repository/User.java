package com.tst.user.repository;

import lombok.Data;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/29/19.
 */
@Data
public class User {
    private String id;
    private String username;
    private String lastName;
    private String firstName;
    private String password;
}
