package Web.WebTestSteps;

import Web.PageObjects.Login_User_PO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login_Test_Steps {

    WebDriver driver;
    public Login_Test_Steps(WebDriver remoteDriver)
    {
        driver = remoteDriver;
    }

    public WebDriverWait wait;
    public Login_User_PO correctEmailAndPasswordPo;

    public void openLoginPage()
    {
        correctEmailAndPasswordPo = new Login_User_PO(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        correctEmailAndPasswordPo.OpenLoginSignUp.click();
        wait.until(ExpectedConditions.visibilityOf(correctEmailAndPasswordPo.VerifyLoginPage));
        Assert.assertTrue(correctEmailAndPasswordPo.VerifyLoginPage.isDisplayed());
    }

    public void enterLoginCredentials()
    {
        correctEmailAndPasswordPo = new Login_User_PO(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        correctEmailAndPasswordPo.EnterEmail.sendKeys("krunal@yopmail.com");
        correctEmailAndPasswordPo.EnterPassword.sendKeys("Krunal@123");
        correctEmailAndPasswordPo.LoginButton.click();
    }

    public void verifyAfterLoginUser()
    {
        correctEmailAndPasswordPo = new Login_User_PO(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(correctEmailAndPasswordPo.DeleteAccountButton));
        Assert.assertEquals(correctEmailAndPasswordPo.VerifyUserName.getText(),"Krunal");
    }

    public void deleteAccount()
    {
        correctEmailAndPasswordPo = new Login_User_PO(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        correctEmailAndPasswordPo.DeleteAccountButton.click();
        Assert.assertTrue(correctEmailAndPasswordPo.VerifyAccountDeletedPage.isDisplayed());
    }


}
