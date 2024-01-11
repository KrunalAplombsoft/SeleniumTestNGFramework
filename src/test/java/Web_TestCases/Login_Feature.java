package Web_TestCases;

import Utilities.WebBaseClass;

import org.testng.annotations.Test;

public class Login_Feature extends WebBaseClass {

    @Test(groups = {"WebSmoke","CorrectEmail"})
    public void Login_User_With_Correct_Email_And_Password()
    {
        System.out.println("Smoke Test");
    }

    @Test(groups = {"WebSanity","IncorrectEmail"})
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        System.out.println("Sanity Test");
    }
}
