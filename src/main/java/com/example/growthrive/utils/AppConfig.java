package com.example.growthrive.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = AppConfig.class.getResourceAsStream("/config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("Unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get a property by key with a default value
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getAppIcon(){
        return getProperty("app.icon", "/icons/default-icon.png");
    }

    public String getAppName(){
      return  AppConfig.getProperty("app.name", "Default App Name");
    }

    // Optional: Method to get a property without a default value
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
