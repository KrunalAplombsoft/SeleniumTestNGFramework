package TestCases;

import Utilities.BaseClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_Feature extends BaseClass {

    @Test(groups = {"Smoke"})
    public void Login_User_With_Correct_Email_And_Password()
    {
        System.out.println("Smoke Test");
    }

    @Test(groups = {"Sanity"})
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        System.out.println("Sanity Test");
    }
}
