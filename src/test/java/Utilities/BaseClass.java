package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClass {

    public static WebDriver webDriver;
    @Test
    public void setUp()
    {
//        System.setProperty("webdriver.chrome.driver","C:/Users/01/Downloads/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://aplombsoft.com/");
        webDriver.manage().window().maximize();
        System.out.println("Chrome Browser Start Successfully");
    }
}
