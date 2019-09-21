package com.abc.perCapitalIncome.test;

import java.io.File;

import javax.annotation.Generated;
import javax.annotation.Resource;

import com.abc.perCapitalIncome.helper.ConstantVariables;
import com.abc.perCapitalIncome.service.FileLoader;
import com.abc.perCapitalIncome.service.Impl.FileLoaderCSV;
/*
import org.junit.*;
import org.junit.Assert.*



public class MainTest {
    
    String testFileInput = "Test_Input.csv";
    String testFileOutput = "Test_output.csv";
    
    //@Resource
    //FileLoader fileLoader;
    
   FileLoader fileLoader = new FileLoaderCSV();
    
    @Before
    public void createTestFiles(){
        String fileData  = "City,Country,Gender,Currency,Average Income\nHyderabad,IND,M,INR,268560\nNew York,USA,F,USD,64971";
        fileLoader.generateFile(ConstantVariables.INPUT_FILE_PATH, testFileInput ,fileData);
    }
    
    @After
    public void deleteTestFiles(){
        new File(ConstantVariables.INPUT_FILE_PATH+testFileInput).deleteOnExit();
        new File(ConstantVariables.INPUT_FILE_PATH+testFileOutput).deleteOnExit();
    }
    
    @Test
    public void fileLoaderTest(){
        File inputFile = new File(ConstantVariables.INPUT_FILE_PATH+testFileInput);
        boolean isLoaded = fileLoader.loadFile(inputFile);
        
        assertEquals(true,isLoaded);
        
        boolean isReportGenerated = fileLoader.generateReport(ConstantVariables.INPUT_FILE_PATH+testFileInput);
        
        assertEquals(true,isReportGenerated);
    }
    
    
} */
