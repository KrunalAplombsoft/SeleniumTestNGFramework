package Utilities;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    String URL;
    public static Properties prop;
    public static WebDriver webDriver;

    @BeforeTest(groups = {"WebSmoke","WebSanity"})
    public void first() throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("./config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome"))
        {
            webDriver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            webDriver = new FirefoxDriver();
        }
        else
        {
            System.out.println("You have selected wrong web driver please check again!!");
        }
//        webDriver.navigate().to("https://automationexercise.com/");
        webDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod(groups = {"ApiSmoke"})
    public void setup()
    {
        try
        {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "./config.properties");
            FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir") + "./DataStore.properties");
            prop.load(ip);
            prop.load(ip1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        URL = prop.getProperty("URL");
    }

    @AfterTest(groups = {"WebSmoke","WebSanity"})
    public void tearDown()
    {
        webDriver.close();
    }
}
