/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import com.chipsolutions.cartodbapi.exceptions.CartoDbCommandException;
import com.chipsolutions.cartodbapi.exceptions.CartoDbException;
import com.chipsolutions.cartodbapi.exceptions.CartoDbParseResponseException;
import com.chipsolutions.cartodbapi.exceptions.CartoDbUnexpectedException;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author luis
 */
public abstract class CartoDbService {
    protected Retrofit retrofit;
       
    private static final String API_URL = "https://{user}.cartodb.com/";
    
    protected final String apiUrl;
    protected final String user;
    protected final String apiKey;

    public CartoDbService(String user, String apiKey){
        this(user,apiKey,false);
    }
    
    public CartoDbService(String user, String apiKey, boolean debug){
        this.user = user;
        this.apiKey = apiKey; 
                
        apiUrl = API_URL.replace("{user}", user);
        
        if (debug){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();    
        } else {
            retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();    
        }
        
    }   
    
    public <T> T executeCall(Call<T> call) throws CartoDbException{
        
        try{
            Response<T> response = call.execute();
            if (!response.isSuccessful()){            
                try {
                    throw new CartoDbCommandException(response.errorBody().string());
                } catch (IOException ex) {
                    throw new CartoDbUnexpectedException(ex.getMessage(),ex);
                }
            }
            T decodedResponse = response.body();
            if (decodedResponse == null) throw new CartoDbParseResponseException("error decoding response");
            
            return decodedResponse;
        } catch (IOException ex){
            throw new CartoDbCommandException(ex.getMessage(),ex);
        }
    }
}
