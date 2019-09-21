package com.abc.perCapitalIncome.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.abc.perCapitalIncome.helper.ConstantVariables;
import com.abc.perCapitalIncome.service.FileLoader;

public class FileLoaderCSV implements FileLoader{
    List<String[]> fileData = null ;
    
    @Override
    public boolean loadFile(File file) {
        
        try(Stream<String> stream = Files.lines(file.toPath());){
            
            fileData = stream.filter(e -> !e.contains("Average Income")).map(e->e.split(",")).collect(Collectors.toList());
            return true;
            
        }catch (IOException e) {
            System.out.println("Exception while readering file"+e.getMessage());
        }
        
        
        return false;
    }

    @Override
    public boolean generateReport(String filename) {
        
        //fileStream.parallel().collect(Collectors.);
        System.out.println("generateReport : ");
        
       //Map<Object,Double> data = 
       StringBuilder sb = new StringBuilder("Country/City,Gender,Average Income (In USD)");
       fileData.stream().collect(
       Collectors.groupingBy(
       e -> Arrays.asList((e[1].trim().isEmpty()?e[0]:e[1]),e[2]),
       Collectors.summingDouble(e -> getAmountInUSD(e[3],Double.valueOf(e[4]))) ) ).forEach((k,v) ->{
            sb.append("\n");
            sb.append(k.stream().collect(Collectors.joining(",")));
            sb.append(",");
            sb.append(v);
       });
        
       //System.out.println();
        
        return generateFile(ConstantVariables.OUTPUT_FILE_PATH,filename,sb.toString());
    }
       
    
}
