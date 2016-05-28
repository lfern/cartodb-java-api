/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author luis
 */
public interface CartoDbSqlApi {
 
    @POST("api/v2/sql")
    Call<CbSqlResponse> executeQuery( @Query("q") String q, @Query("api_key") String apiKey);
    
    
}

