package Web.Web_TestCases;

import Web.Utilities.WebBaseClass;

import org.testng.annotations.Test;

public class Login_Feature extends WebBaseClass {

    @Test(priority = 1, groups = {"Web","Smoke"})
    public void Login_User_With_Correct_Email_And_Password()
    {
        System.out.println("Smoke Test");
    }

    @Test(groups = {"Web","Sanity"})
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        System.out.println("Sanity Test");
    }
}
