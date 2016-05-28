/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import com.chipsolutions.cartodbapi.exceptions.CartoDbException;
import retrofit2.Call;

/**
 *
 * @author luis
 */
public class CartoDbSqlService extends CartoDbService{
    private CartoDbSqlApi api;
    
    public CartoDbSqlService(String user, String apiKey){
        this(user,apiKey,false);
    }
    
    public CartoDbSqlService(String user, String apiKey, boolean debug){
        super(user,apiKey,debug);
        api = retrofit.create(CartoDbSqlApi.class);
    }
    
   
    public CbSqlResponse executeQuery(String query) throws CartoDbException{
        
        Call<CbSqlResponse> call = api.executeQuery(query, apiKey);
        
        CbSqlResponse decodedResponse = executeCall(call);
        return decodedResponse;
        
    }
   
}
