package com.norg.home18.chat.exception;

import java.io.Serializable;

/**
 * Если клиент прислал неподходящие данные.
 */
public class WrongInputException extends RuntimeException implements Serializable {
    public WrongInputException(String s) {
        super(s);
    }

    public WrongInputException() {
    }
}
