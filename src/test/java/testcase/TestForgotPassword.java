package testcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestForgotPassword  {
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }

    @Test (testName = "Input Correct Username Forgot Password",priority = 7)
    public static void inputcorrect() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput(webForm.USERNAME);
        Thread.sleep(2000);
        webForm.clickResetPassword();
        Thread.sleep(1000);
        //Belum bisa assert hidden text
    }
    @Test (testName = "Input Incorrect Username Forgot Password",priority = 8)
    public static void inputincorrect() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("Solo");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        Thread.sleep(1000);
        //Belum bisa assert hidden text
    }
    @Test (testName = "Input empty Username Forgot Password",priority = 9)
    public static void inputemptyforgot() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        Thread.sleep(1000);
        //Belum bisa assert hidden text
    }
    @Test (testName = "Click Cancel",priority = 10)
    public static void clickcancel() throws InterruptedException{
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.clickButtonCancel();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
    }
    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
    @AfterSuite
    public static void sendemail(){
    SendMailSSLWithAttachment.sendmail();
    }
}
