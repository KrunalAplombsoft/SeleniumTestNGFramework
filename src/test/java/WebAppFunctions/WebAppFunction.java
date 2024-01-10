package WebAppFunctions;

import PageObjects.Login_User_With_Correct_Email_And_Password_PO;
import PageObjects.Logout_User_PO;
import PageObjects.Register_User_PO;
import PageObjects.User_With_Incorrect_Email_And_Password_PO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebAppFunction {

    WebDriver driver;
    public WebAppFunction(WebDriver remoteDriver)
    {
        driver = remoteDriver;
    }

    public WebDriverWait wait;

    ///////////////////Start TC001_Register_User//////////////////
    public void Register_User()
    {
        Register_User_PO registerUserPo = new Register_User_PO(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Assert.assertTrue(registerUserPo.VerifyHome.getAttribute("style").contains("orange"));
        registerUserPo.OpenSignUp.click();
        wait.until(ExpectedConditions.visibilityOf(registerUserPo.VerifySignupPage));
        Assert.assertTrue(registerUserPo.VerifySignupPage.isDisplayed());
        registerUserPo.EnterName.sendKeys("Krunal");
        registerUserPo.EnterEmail.sendKeys("krunal@yopmail.com");
        registerUserPo.SignupButton.click();
        wait.until(ExpectedConditions.visibilityOf(registerUserPo.VerifyAccountInformationPage));
        Assert.assertTrue(registerUserPo.VerifyAccountInformationPage.isDisplayed());
        registerUserPo.SelectMr.click();
        String Username = registerUserPo.EnterName.getAttribute("value");
        registerUserPo.EnterPassword.sendKeys("Krunal@123");
        Select drpDays = new Select(registerUserPo.SelectDays);
        drpDays.selectByVisibleText("11");
        Select drpMonths = new Select(registerUserPo.SelectMonths);
        drpMonths.selectByVisibleText("May");
        Select drpYears = new Select(registerUserPo.SelectYears);
        drpYears.selectByVisibleText("1997");
        registerUserPo.SelectNewsLetter.click();
        registerUserPo.SelectOffers.click();
        registerUserPo.EnterFirstName.sendKeys("Krunal");
        registerUserPo.EnterLastName.sendKeys("Parekh");
        registerUserPo.EnterCompany.sendKeys("Aplombsoft");
        registerUserPo.EnterAddress1.sendKeys("Gujarat, India");
        registerUserPo.EnterAddress2.sendKeys("Ahmedabad,India");
        Select drpCountry = new Select(registerUserPo.SelectCountry);
        drpCountry.selectByVisibleText("India");
        registerUserPo.EnterState.sendKeys("Gujarat");
        registerUserPo.EnterCity.sendKeys("Ahmedabad");
        registerUserPo.EnterZipcode.sendKeys("384410");
        registerUserPo.EnterMobileNumber.sendKeys("1234567890");
        registerUserPo.CreateAccountButton.click();
        wait.until(ExpectedConditions.visibilityOf(registerUserPo.VerifyAccountCreatedPage));
        Assert.assertTrue(registerUserPo.VerifyAccountCreatedPage.isDisplayed());
        registerUserPo.ContinueButton.click();
        wait.until(ExpectedConditions.visibilityOf(registerUserPo.DeleteAccountButton));
        Assert.assertEquals(registerUserPo.VerifyUserName.getText(),Username);
        registerUserPo.DeleteAccountButton.click();
        Assert.assertTrue(registerUserPo.VerifyAccountDeletedPage.isDisplayed());
    }
    ///////////////////End TC001_Register_User//////////////////

    ///////////////////Start TC002_Login_User_With_Correct_Email_And_Password//////////////////
    public void Login_User_With_Correct_Email_And_Password()
    {
        Login_User_With_Correct_Email_And_Password_PO correctEmailAndPasswordPo = new Login_User_With_Correct_Email_And_Password_PO(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Assert.assertTrue(correctEmailAndPasswordPo.VerifyHome.getAttribute("style").contains("orange"));
        correctEmailAndPasswordPo.OpenLogin.click();
        wait.until(ExpectedConditions.visibilityOf(correctEmailAndPasswordPo.VerifyLoginPage));
        Assert.assertTrue(correctEmailAndPasswordPo.VerifyLoginPage.isDisplayed());
        correctEmailAndPasswordPo.EnterEmail.sendKeys("krunal@yopmail.com");
        correctEmailAndPasswordPo.EnterPassword.sendKeys("Krunal@123");
        correctEmailAndPasswordPo.LoginButton.click();
        wait.until(ExpectedConditions.visibilityOf(correctEmailAndPasswordPo.DeleteAccountButton));
        Assert.assertEquals(correctEmailAndPasswordPo.VerifyUserName.getText(),"Krunal");
        correctEmailAndPasswordPo.DeleteAccountButton.click();
        Assert.assertTrue(correctEmailAndPasswordPo.VerifyAccountDeletedPage.isDisplayed());
    }
    ///////////////////End TC002_Login_User_With_Correct_Email_And_Password//////////////////

    ///////////////////Start TC003_User_With_Incorrect_Email_And_Password//////////////////
    public void User_With_Incorrect_Email_And_Password()
    {
        User_With_Incorrect_Email_And_Password_PO userWithIncorrectEmailAndPasswordPo = new User_With_Incorrect_Email_And_Password_PO(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Assert.assertTrue(userWithIncorrectEmailAndPasswordPo.VerifyHome.getAttribute("style").contains("orange"));
        userWithIncorrectEmailAndPasswordPo.OpenLogin.click();
        wait.until(ExpectedConditions.visibilityOf(userWithIncorrectEmailAndPasswordPo.VerifyLoginPage));
        Assert.assertTrue(userWithIncorrectEmailAndPasswordPo.VerifyLoginPage.isDisplayed());
        userWithIncorrectEmailAndPasswordPo.EnterEmail.sendKeys("krunal@yopmail.com");
        userWithIncorrectEmailAndPasswordPo.EnterPassword.sendKeys("Krunal@123");
        userWithIncorrectEmailAndPasswordPo.LoginButton.click();
        Assert.assertTrue(userWithIncorrectEmailAndPasswordPo.VerifyValidationMessage.isDisplayed());
    }
    ///////////////////End TC003_User_With_Incorrect_Email_And_Password//////////////////

    ///////////////////Start TC004_Logout_User///////////////////////////////////////////
    public void Logout_User()
    {
        Logout_User_PO logoutUserPo = new Logout_User_PO(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Assert.assertTrue(logoutUserPo.VerifyHome.getAttribute("style").contains("orange"));
        logoutUserPo.OpenLogin.click();
        wait.until(ExpectedConditions.visibilityOf(logoutUserPo.VerifyLoginPage));
        Assert.assertTrue(logoutUserPo.VerifyLoginPage.isDisplayed());
        logoutUserPo.EnterEmail.sendKeys("krunal@yopmail.com");
        logoutUserPo.EnterPassword.sendKeys("Krunal@123");
        logoutUserPo.LoginButton.click();
        wait.until(ExpectedConditions.visibilityOf(logoutUserPo.DeleteAccountButton));
        Assert.assertEquals(logoutUserPo.VerifyUserName.getText(),"Krunal");
        logoutUserPo.LogoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(logoutUserPo.VerifyLoginPage));
        Assert.assertTrue(logoutUserPo.VerifyLoginPage.isDisplayed());
    }
    ///////////////////End TC004_Logout_User////////////////////////////////////////////


}
