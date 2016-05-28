/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import com.chipsolutions.cartodbapi.exceptions.CartoDbException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 *
 * @author luis
 */

public class CartoDbMapService extends CartoDbService{
    private CartoDbMapApi api;
    

    public CartoDbMapService(String user, String apiKey){
        this(user,apiKey,false);
    }
    
    public CartoDbMapService(String user, String apiKey, boolean debug){
        super(user, apiKey,debug);
        api = retrofit.create(CartoDbMapApi.class);
    }
    
    public CbMapCreateMapResponse createMap(String tableName) throws CartoDbException{
        String map;
        try {
            map = getFile("maptemplate2.json");
        } catch (IOException ex){
            throw new CartoDbException("internal error");
        }
        map = map.replace("%table%", tableName);
        RequestBody fbody = RequestBody.create(MediaType.parse("application/octet-stream"), map);
        
        Call<CbMapCreateMapResponse> call = api.createMap(fbody, apiKey);  
        
        CbMapCreateMapResponse decodedResponse = executeCall(call);
        return decodedResponse;
        
    }
    
    private String getFile(String fileName) throws FileNotFoundException {

	StringBuilder result = new StringBuilder("");

	//Get file from resources folder
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(fileName).getFile());

	Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
            }
        } finally{
            if (scanner != null)   scanner.close();
        }

		
	return result.toString();

  }

}
