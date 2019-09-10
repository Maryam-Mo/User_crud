package com.tst.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Maryam Moein <maryam.moein@safesat.com.ph> on 8/30/19.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException extends Exception{
    public DuplicateException(String message) {
        super(message);
    }
}
