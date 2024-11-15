package Utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {


    public static void loadProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("C:\\Users\\yraga\\IdeaProjects\\Vois_Task\\src\\main\\resources\\properties\\LoginCredentials.properties");
        properties.load(inputStream);

        System.getProperties().putAll(properties);
    }

    public static String getProperty(String key)
    {
        return System.getProperty(key);
    }
}
