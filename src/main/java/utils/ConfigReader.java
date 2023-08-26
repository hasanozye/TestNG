package utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    /*
    config.properties dosyasından istenilen veriyi
    static method ile return edecek
     */
    static String file = "src/main/java/resources/config.properties";

    public static String get(String key) {
        Properties properties = new Properties();

        try {
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);

            fileReader.close();
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
