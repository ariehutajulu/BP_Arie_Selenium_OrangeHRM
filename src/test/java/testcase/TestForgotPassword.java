package testcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestForgotPassword {
    static WebDriver driver = new ChromeDriver();
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeclasss()  {
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Forgot Password");
    }

    @Test (testName = "Input Correct Username Forgot Password",priority = 7)
    public void inputcorrect() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.INFO,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput(webForm.USERNAME);
        test.log(LogStatus.INFO,"Input forgot username");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.INFO,"Click Reset");
        Thread.sleep(1000);
        //Belum bisa assert hidden text
    }
    @Test (testName = "Input Incorrect Username Forgot Password",priority = 8)
    public void inputincorrect() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.INFO,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("Solo");
        test.log(LogStatus.INFO,"Input incorrect Username");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.INFO,"Click Reset Password");
        Thread.sleep(1000);
        //Belum bisa assert hidden text
    }
    @Test (testName = "Input empty Username Forgot Password",priority = 9)
    public void inputemptyforgot() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.INFO,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("");
        test.log(LogStatus.INFO,"Input empty username");

        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.INFO,"Click reset password");
        Thread.sleep(1000);
        //Belum bisa assert hidden text
    }
    @Test (testName = "Click Cancel",priority = 10)
    public void clickcancel() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.INFO,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.clickButtonCancel();
        test.log(LogStatus.INFO,"Click Cancel");

        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
    }
    @AfterClass
    public void cleanUps(){
        driver.manage().deleteAllCookies();
        driver.close();
        report.endTest(test);
        report.flush();
    }

}
