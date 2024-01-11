package Utilities;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiBaseClass {

    String URL;
    public static Properties prop;
    @BeforeMethod(groups = {"ApiSmoke"})
    public void setup()
    {
        try
        {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "./apiconfig.properties");
            FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir") + "./ApiDataStore.properties");
            prop.load(ip);
            prop.load(ip1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        URL = prop.getProperty("URL");
    }

    public RequestSpecification base()
    {
        //Specify base URI
        RestAssured.baseURI = URL;

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        return httpRequest;
    }
}
