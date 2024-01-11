package TestCases;

import Utilities.BaseClass;

import org.testng.annotations.Test;

public class Login_Feature extends BaseClass {

    @Test(groups = {"Smoke","CorrectEmail"})
    public void Login_User_With_Correct_Email_And_Password()
    {
        System.out.println("Smoke Test");
    }

    @Test(groups = {"Sanity","IncorrectEmail"})
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        System.out.println("Sanity Test");
    }
}
