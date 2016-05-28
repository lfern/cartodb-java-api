/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import java.util.List;
import java.util.Map;

/**
 *
 * @author luis
 */
public class CbSqlResponse {
    List <Map<String,Object>> rows;
    String time;
    Map<String, Map<String, String>> fields;
    int total_rows;
}
