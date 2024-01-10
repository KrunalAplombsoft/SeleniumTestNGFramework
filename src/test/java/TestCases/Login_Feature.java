package TestCases;

import Utilities.BaseClass;
import org.testng.annotations.Test;

public class Login_Feature extends BaseClass {

    @Test(groups = {"Smoke"})
    public void Login_User_With_Correct_Email_And_Password()
    {
        System.out.println("Smoke Test");
//        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
//        loginTestSteps.openLoginPage();
//        loginTestSteps.enterLoginCredentials();
//        loginTestSteps.verifyAfterLoginUser();
//        loginTestSteps.deleteAccount();
    }

    @Test(groups = {"Sanity"})
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        System.out.println("Sanity Test");
//        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
//        loginTestSteps.openLoginPage();
//        loginTestSteps.enterLoginCredentials();
//        loginTestSteps.verifyAfterLoginUser();
//        loginTestSteps.deleteAccount();
    }
//    @Test
//    public void Logout_User()
//    {
//        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
//        loginTestSteps.openLoginPage();
//        loginTestSteps.enterLoginCredentials();
//        loginTestSteps.verifyAfterLoginUser();
//        loginTestSteps.deleteAccount();
//    }
}
