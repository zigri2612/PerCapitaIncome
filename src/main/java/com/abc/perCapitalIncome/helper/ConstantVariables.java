package com.abc.perCapitalIncome.helper;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConstantVariables {
    
    private static Properties ps = new Properties();
    
    static{
        
     System.out.println(new File("src/resources/application.properties").getAbsoluteFile().isFile());
        
        try(FileReader fr = new FileReader(new File("src/resources/application.properties").getAbsoluteFile());)
        {
            ps.load(fr);
          
        }catch(Exception e){
            System.out.println("Exception while loading properties : "+e.getMessage());
        }
    
    }
    

     public static String INPUT_FILE_PATH = ps.getProperty("input_file_path"); 
     public static String OUTPUT_FILE_PATH = ps.getProperty("output_file_path");
     
     //Currency rate with respect USD
     public static String USD_INR = ps.getProperty("usd_inr"); 
     public static String USD_GBP = ps.getProperty("usd_gbp"); 
     public static String USD_SGD = ps.getProperty("usd_sgd"); 
     public static String USD_HKD = ps.getProperty("usd_hkd"); 

     public static String getProperty(String property){
         return ps.getProperty(property);
     }   
}
