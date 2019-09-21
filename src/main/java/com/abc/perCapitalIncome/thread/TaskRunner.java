package com.abc.perCapitalIncome.thread;

import java.io.File;

import com.abc.perCapitalIncome.service.FileLoader;

public class TaskRunner implements Runnable{
    private FileLoader fileLoader;
    private File file;    
    
     public TaskRunner(FileLoader fileLoader,File file) {
        this.fileLoader = fileLoader;
        this.file = file;
     } 
    
    @Override
    public void run() {
            boolean isLoaded = fileLoader.loadFile(file);
            System.out.println(String.format("%s loaded : %b by %s",file.getName(),isLoaded,Thread.currentThread().getName()));
            String outputFilename = file.getName().replaceAll("(?i)Input","Output");
            if(isLoaded){
                fileLoader.generateReport(outputFilename);
            }        
    }
    
}
