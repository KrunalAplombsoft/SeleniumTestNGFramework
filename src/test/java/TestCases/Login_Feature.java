package TestCases;

import Utilities.BaseClass;
import WebAppFunctions.Login_Test_Steps;
import org.testng.annotations.Test;

public class Login_Feature extends BaseClass {

    @Test
    public void Login_User_With_Correct_Email_And_Password()
    {
        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
        loginTestSteps.openLoginPage();
        loginTestSteps.enterLoginCredentials();
        loginTestSteps.verifyAfterLoginUser();
        loginTestSteps.deleteAccount();
    }

    @Test
    public void Login_User_With_Incorrect_Email_And_Password()
    {
        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
        loginTestSteps.openLoginPage();
        loginTestSteps.enterLoginCredentials();
        loginTestSteps.verifyAfterLoginUser();
        loginTestSteps.deleteAccount();
    }
    @Test
    public void Logout_User()
    {
        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
        loginTestSteps.openLoginPage();
        loginTestSteps.enterLoginCredentials();
        loginTestSteps.verifyAfterLoginUser();
        loginTestSteps.deleteAccount();
    }
}
