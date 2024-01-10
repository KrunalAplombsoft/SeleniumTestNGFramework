package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_User_PO {

    WebDriver webDriver;

    public Register_User_PO(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement VerifyHome;

    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
    public WebElement OpenSignUp;

    @FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    public WebElement VerifySignupPage;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement EnterName;

    @FindBy(xpath = "//form[@action='/signup']//input[@name='email']")
    public WebElement EnterEmail;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    public WebElement SignupButton;

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    public WebElement VerifyAccountInformationPage;

    @FindBy(xpath = "//input[@value='Mr']")
    public WebElement SelectMr;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement EnterPassword;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement SelectDays;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement SelectMonths;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement SelectYears;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement SelectNewsLetter;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement SelectOffers;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement EnterFirstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement EnterLastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement EnterCompany;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement EnterAddress1;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement EnterAddress2;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement SelectCountry;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement EnterState;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement EnterCity;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement EnterZipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement EnterMobileNumber;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    public WebElement CreateAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    public WebElement VerifyAccountCreatedPage;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    public WebElement ContinueButton;

    @FindBy(xpath = "//a[contains(text(),' Delete Account')]")
    public WebElement DeleteAccountButton;

    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]//b")
    public WebElement VerifyUserName;

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    public WebElement VerifyAccountDeletedPage;

}
