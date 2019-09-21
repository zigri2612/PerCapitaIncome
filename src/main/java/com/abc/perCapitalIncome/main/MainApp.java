package com.abc.perCapitalIncome.main;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.abc.perCapitalIncome.helper.ConstantVariables;
import com.abc.perCapitalIncome.service.FileLoader;
import com.abc.perCapitalIncome.service.Impl.FileLoaderCSV;
import com.abc.perCapitalIncome.thread.TaskRunner;

public class MainApp {
    public static void main(String... args){
        FileLoader fileLoader = new FileLoaderCSV();
        System.out.println(ConstantVariables.INPUT_FILE_PATH);
        System.out.println(ConstantVariables.OUTPUT_FILE_PATH);
        System.out.println(ConstantVariables.getProperty("USD_INR"));
        System.out.println(ConstantVariables.getProperty("USD_SGP"));
        
        ExecutorService executor = Executors.newFixedThreadPool(10); 
        //executor.
        
        File[] files = fileLoader.getFiles(ConstantVariables.INPUT_FILE_PATH);
        System.out.println("Sys : "+files);
        if(files != null)
        for(File file : files){
            executor.execute(new TaskRunner(fileLoader,file));
        }
        
        executor.shutdown();
    }
    
}
