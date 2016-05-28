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
public class CartoDbParseResponseException extends CartoDbException{

    public CartoDbParseResponseException(String message) {
        super(message);
    }

    public CartoDbParseResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartoDbParseResponseException(Throwable cause) {
        super(cause);
    }

    public CartoDbParseResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
