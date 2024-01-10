package TestCases;

import Utilities.BaseClass;
import WebAppFunctions.WebAppFunction;
import org.testng.annotations.Test;

public class TC003_User_With_Incorrect_Email_And_Password extends BaseClass {

    @Test
    public void User_With_Incorrect_Email_And_Password()
    {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.User_With_Incorrect_Email_And_Password();
    }
}
