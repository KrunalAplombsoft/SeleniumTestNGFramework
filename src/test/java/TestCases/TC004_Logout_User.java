package TestCases;

import Utilities.BaseClass;
import WebAppFunctions.WebAppFunction;
import org.testng.annotations.Test;

public class TC004_Logout_User extends BaseClass {

    @Test
    public void Logout_User()
    {
        WebAppFunction webAppFunction = new WebAppFunction(webDriver);
        webAppFunction.Logout_User();
    }
}
