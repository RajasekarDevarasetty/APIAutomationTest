package Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public ConfigReader()
    {
        BufferedReader reader;

        try
        {
            String propertyFilePath = "src/test/resources/APIEndpoints.properties";
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try
            {
                properties.load(reader);
                reader.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static String getWeatherDataEndpoint()
    {
        return properties.getProperty("WhetherDataEndPoint");
    }
}
