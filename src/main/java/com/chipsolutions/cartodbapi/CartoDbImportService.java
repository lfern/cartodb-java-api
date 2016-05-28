/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import com.chipsolutions.cartodbapi.exceptions.CartoDbException;
import com.chipsolutions.cartodbapi.exceptions.CartoDbTimeout;
import java.io.File;
import java.util.Date;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 *
 * @author luis
 */
public class CartoDbImportService extends CartoDbService{
    private CartoDbImportApi api;
    
    public CartoDbImportService(String user, String apiKey){
        this(user,apiKey,false);
    }
    
    public CartoDbImportService(String user, String apiKey, boolean debug){
        super(user,apiKey,debug);
        api = retrofit.create(CartoDbImportApi.class);
    }
    
   
    public CbImportResponse importFile(File file) throws CartoDbException{
        RequestBody fbody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        
        Call<CbImportResponse> call = api.importFile(fbody, apiKey);  
        
        CbImportResponse decodedResponse = executeCall(call);
        return decodedResponse;
        
    }
    public CbImportStatus importStatus(String id,int timeoutSeconds) throws CartoDbException{
        Date d1 = new Date();
      
        while (true){
            Call<CbImportStatus> call= api.importStatus(id,apiKey);

            CbImportStatus status = executeCall(call);

            if ("complete".equals(status.state)){
                return status;
            } else if ("failure".equals(status.state)){
                return status;
            }
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException ex){

            }
            long seconds = (new Date().getTime()-d1.getTime())/1000;
            if (seconds > timeoutSeconds){
                throw new CartoDbTimeout("timeout");
            }
        }
        
    }
}
