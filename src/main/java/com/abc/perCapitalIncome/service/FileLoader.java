package com.abc.perCapitalIncome.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.abc.perCapitalIncome.helper.ConstantVariables;

public interface FileLoader {

    public boolean loadFile(File file);
    public boolean generateReport(String filename);

    default File[] getFiles(String filePath) {
        File file = new File(filePath);
        System.out.println("Abs Path: "+(new File("").getAbsolutePath()));
        System.out.println("Abs Path: "+file.getAbsolutePath());
        System.out.println(" exists: "+file.exists());
        System.out.println("isDirectory : "+file.isDirectory());
        
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }

        return null;
    }

    
     default boolean generateFile(String filepath,String filename,String fileData){ 
        File outputFile = new File(filepath+filename);
        try(FileWriter fileWriter = new FileWriter(outputFile);) {
            fileWriter.write(fileData);
            System.out.println(outputFile.getName()+" is exists : "+outputFile.exists());
            return true;
        }catch (IOException e) {
            System.out.println("Exception while file writing.");
        } return false;         
      }
      
    default public Double getAmountInUSD(String currency,Double amount){
          String currenyRate = null;
          
          switch(currency){
              case "INR" : currenyRate = ConstantVariables.USD_INR;
                        break;
              case "GBP" : currenyRate = ConstantVariables.USD_GBP;
                        break;
              case "SGD" : currenyRate = ConstantVariables.USD_SGD;
                        break;
              case "HKD" : currenyRate = ConstantVariables.USD_HKD;
                        break;
              default : currenyRate = ConstantVariables.getProperty("USD_"+currency);
          }
          
          Double rate = 1d;
          if(currenyRate != null){
              rate = Double.valueOf(currenyRate);
          }else if(!"USD".equals(currency)){
              System.out.println(String.format("*********Currency conversion rate for %s is not available.**********",currency));
          }
          
          return amount/rate;
          
      }
}
