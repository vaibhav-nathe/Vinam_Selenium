package io.vinam.webpages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtiles {

    private PropertiesUtiles() {

    }

    public static Properties loadPropertiesFile(String environment) throws IOException {
        Properties config = new Properties();
        final String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config-" + environment + ".properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            config.load(fis);
            return config;
        }
    }

}
