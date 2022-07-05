package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1 -creating properties object
    // we make this private to be inaccessible from outside
    //make static because static runs first and before everything else
    // we will use this object under static method
    private static Properties properties = new Properties();


    static {
        // Create FileInputStream object to open file as a stream in Java memory.

        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            // Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Fie not found in ConfigurationReader class");
            e.printStackTrace();
        }


    }

    public static String getProperty(String keyword){//this is the getter for accessing private properties object on line 13
        return properties.getProperty(keyword);
    }










}
