/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author luis
 */
public class Config {
    public static String APIURL = "";
    public static String USER = "";

    public static void initialize(){
        File file = new File("src/test/resources/config.properties");
        
        InputStream stream = null;
        Properties properties = new Properties();
        try {
            stream = new FileInputStream(file);
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            // You will have to take some action here...
        }finally{
            if (stream != null) try {
                stream.close();
            } catch (IOException ex) {
            }
        }
        // What if properties was not loaded correctly... You will get null back
        APIURL = properties.getProperty("cartodb.apiurl");
        USER = properties.getProperty("cartodb.user");
    }

}