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
    String id;
    String user_id;
    String table_id;
    String data_type;//	file, url, external_table, query, table or datasource.
    String table_name; 
    String state;// enqueued, pending, uploading, unpacking, importing, guessing, complete, or failure.
    String error_code;//
    String queue_id;
    String tables_created_count;
    String synchronization_id;
    boolean type_guessing;
    boolean quoted_fields_guessing;
    boolean content_guessing;
    boolean create_visualization;
    String visualization_id;
    String user_defined_limits;
    String get_error_text;
    String display_name;
    boolean success;
    String warnings;
    boolean is_raster;
}
