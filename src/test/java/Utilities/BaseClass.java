package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver webDriver;

    @BeforeMethod
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
        webDriver.navigate().to("https://automationexercise.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown()
    {
        webDriver.close();
    }
}
