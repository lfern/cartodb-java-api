/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author luis
 */
public interface CartoDbImportApi {
 
    @Multipart
    @POST("api/v1/imports/")
    Call<CbImportResponse> importFile(@Part("file\"; filename=\"shapefile.zip") RequestBody file, @Query("api_key") String apiKey);
    
    @GET("api/v1/imports/{importid}")
    Call<CbImportStatus> importStatus(@Path("importid") String importId, @Query("api_key") String apiKey);
    
}

