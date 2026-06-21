package com.workintech.s19d1.util;

import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {

    private HollywoodValidation() {
    }

    public static void checkId(Long id) {
        if (id == null || id <= 0) {
            throw new ApiException("id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
    }
}
