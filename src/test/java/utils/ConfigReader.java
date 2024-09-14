package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties readProperties (String filePath) {


        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


    public static String getPropertyValue (String key){
        return prop.getProperty(key); //pra me kte method cfardo qe te kerkojme ktu mund ta therrasim esht e elidhur me config.properties kshq if we call username we will see admin, if we call browser we will see chrome wtc


    }


}

