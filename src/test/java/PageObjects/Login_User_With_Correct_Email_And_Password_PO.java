package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_User_With_Correct_Email_And_Password_PO {

    WebDriver webDriver;

    public Login_User_With_Correct_Email_And_Password_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement VerifyHome;

    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
    public WebElement OpenLogin;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    public WebElement VerifyLoginPage;

    @FindBy(xpath = "//form[@action='/login']//input[@name='email']")
    public WebElement EnterEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement EnterPassword;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement LoginButton;

    @FindBy(xpath = "//a[contains(text(),' Delete Account')]")
    public WebElement DeleteAccountButton;

    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]//b")
    public WebElement VerifyUserName;

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    public WebElement VerifyAccountDeletedPage;
}
