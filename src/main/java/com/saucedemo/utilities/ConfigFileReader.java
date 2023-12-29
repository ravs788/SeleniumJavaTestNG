package com.saucedemo.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties;
    private final String propertyFilePath= "src/main/java/com/saucedemo/config/config.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser!= null) return browser;
        else throw new RuntimeException("Browser not specified in the Configuration.properties file.");

    }

    public String getURL()
    {
        String URL = properties.getProperty("url");
        if(URL!= null) return URL;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }
}
