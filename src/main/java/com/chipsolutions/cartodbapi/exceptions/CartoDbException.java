/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi.exceptions;

/**
 *
 * @author luis
 */
public class CartoDbException extends Exception{

    public CartoDbException(String message) {
        super(message);
    }

    public CartoDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartoDbException(Throwable cause) {
        super(cause);
    }

    public CartoDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
