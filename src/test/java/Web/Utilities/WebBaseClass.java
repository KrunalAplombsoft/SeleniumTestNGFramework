package Web.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.maven.shared.utils.io.FileUtils;
import org.codehaus.plexus.util.IOUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

public class WebBaseClass {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    public static WebDriver webDriver;

    @BeforeTest(groups = {"Web","Smoke","Sanity"})
    public void abc (){
        htmlReporter = new ExtentSparkReporter("./Report/ExtentReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine","acer");
        reports.setSystemInfo("OS","Windows 10");
        reports.setSystemInfo("User","Krunal Parekh");
        reports.setSystemInfo("Browser","Chrome");

        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @BeforeMethod(groups = {"Web","Smoke","Sanity"})
    public void first() throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("./Config_Web/webconfig.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome"))
        {
            webDriver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            webDriver = new FirefoxDriver();
        }
        else
        {
            System.out.println("You have selected wrong web driver please check again!!");
        }
//        webDriver.navigate().to("https://automationexercise.com/");
        webDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String dest = System.getProperty("user.dir") +"\\Screenshots\\hello.PNG";
        System.out.println("dest : " + dest);
    }

    public static String capture(WebDriver driver, String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\Screenshots\\"+screenShotName+".PNG";
        System.out.println("dest : " + dest);
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        System.out.println("destination : " + destination);
        String path = destination.getAbsolutePath();

        InputStream is = new FileInputStream(dest);
        byte[] ssBytes = IOUtil.toByteArray(is);
        String base64 = Base64.getEncoder().encodeToString(ssBytes);

        return base64;
    }

    @AfterMethod(groups = {"Web","Smoke","Sanity"})
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS)
        {
            test = reports.createTest(result.getName()).assignCategory("Functional Test").assignDevice("Chrome").assignAuthor("Krunal Prekh");
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS ", ExtentColor.GREEN));
        }
        else if (result.getStatus() == ITestResult.FAILURE)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy_HH mm ss");
            String timestamp = dateFormat.format(new Date());

            String abc = capture(webDriver,result.getName()+"_"+timestamp);
            test = reports.createTest(result.getName()).assignCategory("Functional Test").assignDevice("Chrome").assignAuthor("Krunal Prekh");
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL ", ExtentColor.RED))
                    .addScreenCaptureFromBase64String(abc,result.getName())
                    .fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIP", ExtentColor.YELLOW));
        }

        webDriver.close();
    }

    @AfterTest(groups = {"Web","Smoke","Sanity"})
    public void flushReport()
    {
        reports.flush();
    }
}
