package Api.Api_TestCases;

import Api.Api_Utilities.ApiBaseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class Get_Demo extends ApiBaseClass {

    @Test(groups = {"ApiSmoke","GetUserData"})
    public void GETUserData()
    {
        //Response object
        Response response = base().request(Method.GET,"/api/users/2");

        //Print Response in Console Window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status Code Verification
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,200);

        try (FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"./ApiDataStore.properties"))
        {
            Properties prop = new Properties();
            prop.load(ip);

            //Set the properties value
            prop.setProperty("GET_User_Id", String.valueOf(response.jsonPath().<Integer>getJsonObject("data.id")));
            prop.setProperty("GET_User_Email",response.jsonPath().getJsonObject("data.email"));
            prop.setProperty("GET_User_FirstName",response.jsonPath().getJsonObject("data.first_name"));
            prop.setProperty("GET_User_LastName",response.jsonPath().getJsonObject("data.last_name"));
            prop.setProperty("GET_User_Image_Avatar",response.jsonPath().getJsonObject("data.avatar"));

            prop.setProperty("GET_User_URL",response.jsonPath().getJsonObject("support.url"));
            prop.setProperty("GET_User_TextMSG",response.jsonPath().getJsonObject("support.text"));

            OutputStream output = new FileOutputStream(System.getProperty("user.dir")+"./ApiDataStore.properties");

            //Save properties to Personal.Properties file
            prop.store(output, "Updated Data");
            System.out.println(prop);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
