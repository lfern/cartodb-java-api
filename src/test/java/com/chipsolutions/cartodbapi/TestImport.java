/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class TestImport {
    
    public TestImport() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    boolean finish = false;
    String apiKey = "7740768a8d071ab897c0d3b3f5f95b6ec01777ec";
    String query = "INSERT INTO shapefile "+
            "(the_geom,comentaris,descgaleri,fecha,id,idactivita,idengros,idgaleria,idprincipa,idsector,nomlocal) "+
            "select "+
            "the_geom,comentaris,descgaleri,fecha,id,idactivita,idengros,idgaleria,idprincipa,idsector,nomlocal "+ 
            "from %table%";
    
    String query2 = "select * from %table%";	

/*    
    @Test
    public void importfile() throws Exception{
        finish = false;
        // Prepare the HTTP request
        CartoDbImportApi service = CartoDbImportService.getImportServiceD();
        
        File file = new File("src/test/resources/shapefile.zip");
        RequestBody fbody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        
        
        Call<CbImportResponse> call = service.importFile(fbody, apiKey);

        // Asynchronously execute HTTP request
        call.enqueue(new Callback<CbImportResponse>() {
            @Override
            public void onResponse(Call<CbImportResponse> call, Response<CbImportResponse> response) {
                // http response status code + headers
                System.out.println("Response status code: " + response.code());

                // isSuccess is true if response code => 200 and <= 300
                if (!response.isSuccessful()) {
                    // print response body if unsuccessful
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        // do nothing
                    }
                    finish = true;
                    return;
                }

                // if parsing the JSON body failed, `response.body()` returns null
                CbImportResponse decodedResponse = response.body();
                if (decodedResponse == null) return;

                // at this point the JSON body has been successfully parsed
                System.out.println("Response (contains request infos):");
                System.out.println("- item_queue_id:         " + decodedResponse.item_queue_id);
                System.out.println("- success:          " + decodedResponse.success);
                
                
                Call<CbImportStatus> call2= service.importStatus(decodedResponse.item_queue_id,apiKey);
                
                call2.enqueue(new Callback<CbImportStatus>(){
                    @Override
                    public void onResponse(Call<CbImportStatus> call, Response<CbImportStatus> response) {
                        // http response status code + headers
                        System.out.println("Response status code: " + response.code());

                        // isSuccess is true if response code => 200 and <= 300
                        if (!response.isSuccessful()) {
                            // print response body if unsuccessful
                            try {
                                System.out.println(response.errorBody().string());
                            } catch (IOException e) {
                                // do nothing
                            }
                            finish = true;
                            return;
                        }

                        // if parsing the JSON body failed, `response.body()` returns null
                        CbImportStatus decodedResponse = response.body();
                        if (decodedResponse == null) return;

                        // at this point the JSON body has been successfully parsed
                        System.out.println("Response (contains request infos):");
                        //System.out.println("- item_queue_id:         " + decodedResponse.itemQueueId);
                        System.out.println("- success:          " + decodedResponse.success);


                        


                        finish = true;
                    }

                    @Override
                    public void onFailure(Call<CbImportStatus> call, Throwable thrwbl) {
                        System.out.println("onFailure");
                        System.out.println(thrwbl.getMessage());
                        finish = true;
                    }    
                });
                
               
                
                
                
            }

            @Override
            public void onFailure(Call<CbImportResponse> call, Throwable thrwbl) {
                System.out.println("onFailure");
                System.out.println(thrwbl.getMessage());
                finish = true;
            }
            
        });
        while (!finish){
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException ex){
                
            }
        }
    }
*/
    @Test
    public void importFile2() throws IOException, Exception{
        CartoDbImportService service = new CartoDbImportService("lfern", apiKey, true);
        
        File file = new File("src/test/resources/shapefile.zip");
        CbImportResponse importResponse = service.importFile(file);
        
        CbImportStatus statusResponse = service.importStatus(importResponse.item_queue_id, 120);
        
        CartoDbSqlService queryService = new CartoDbSqlService("lfern", apiKey,true);
        
        CbSqlResponse sqlResponse = queryService.executeQuery(query.replace("%table%",statusResponse.table_name));
        
        //System.out.println(sqlResponse);
        
    }
    //https://lfern.cartodb.com/tables/shapefile/public/map
    
}
