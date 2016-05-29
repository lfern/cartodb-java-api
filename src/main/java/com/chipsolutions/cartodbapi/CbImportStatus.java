/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chipsolutions.cartodbapi;

/**
 *
 * @author luis
 */
public class CbImportStatus {
    public String id;
    public String user_id;
    public String table_id;
    public String data_type;//	file, url, external_table, query, table or datasource.
    public String table_name; 
    public String state;// enqueued, pending, uploading, unpacking, importing, guessing, complete, or failure.
    public String error_code;//
    public String queue_id;
    public String tables_created_count;
    public String synchronization_id;
    public boolean type_guessing;
    public boolean quoted_fields_guessing;
    public boolean content_guessing;
    public boolean create_visualization;
    public String visualization_id;
    public String user_defined_limits;
    public CbErrorText get_error_text;
    public String display_name;
    public boolean success;
    public String warnings;
    public boolean is_raster;
}
