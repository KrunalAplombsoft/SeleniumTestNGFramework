package Web.Web_TestCases;

import Web.Utilities.WebBaseClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Feature extends WebBaseClass {

    @Parameters({"name","surname"})
    @Test(groups = {"Web","Smoke"})
    public void Login_User_With_Correct_Email_And_Password(String n1, String s1)
    {
        System.out.println("Smoke Test " + n1 + " " + s1);
    }

    @Test(groups = {"Web","Sanity"})
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        System.out.println("Sanity Test");
    }
}
