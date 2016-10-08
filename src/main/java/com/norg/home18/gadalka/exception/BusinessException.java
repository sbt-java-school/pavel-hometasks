package com.norg.home18.gadalka.exception;

/**
 * Created by Norg on 01.10.2016.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException() {

    }

}
