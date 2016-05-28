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
public class CartoDbTimeout extends CartoDbException {

    public CartoDbTimeout(String message) {
        super(message);
    }

    public CartoDbTimeout(String message, Throwable cause) {
        super(message, cause);
    }

    public CartoDbTimeout(Throwable cause) {
        super(cause);
    }

    public CartoDbTimeout(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
