package TestCases;

import Utilities.BaseClass;
import WebAppFunctions.Login_Test_Steps;
import WebAppFunctions.WebAppFunction;
import org.testng.annotations.Test;

public class TC002_Login_User_With_Correct_Email_And_Password extends BaseClass {

    @Test
    public void Login_User_With_Correct_Email_And_Password()
    {
        Login_Test_Steps loginTestSteps = new Login_Test_Steps(webDriver);
        loginTestSteps.openLoginPage();
        loginTestSteps.enterLoginCredentials();
        loginTestSteps.verifyAfterLoginUser();
        loginTestSteps.deleteAccount();
    }
}
