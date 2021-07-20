package testcase;

import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;

public class TestLogin extends OpenBrowser{

    @Test (testName = "Login Valid data",priority = 0)
    public void submitvalid() throws InterruptedException{

        report= ExtentFactory.getInstance();
        test = report.startTest("Test case Login");
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.INFO,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        test.log(LogStatus.INFO,"Input Username");

        Thread.sleep(2000);
        webForm.enterPassword(webForm.PASSWORD);
        test.log(LogStatus.INFO,"Input Password");
        Thread.sleep(2000);
        webForm.clickLogin();
        test.log(LogStatus.INFO,"Click Login");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Welcome Karyawan"));
        test.log(LogStatus.INFO,"Text Verified");

        report.endTest(test);
        report.flush();
    }



//    @Test (testName = "Login empty username",priority = 4)
//    public void submitemptyusername() throws InterruptedException{
//        driver.get(Utils.BASE_URL);
//        driver.manage().window().maximize();
//        test.log(LogStatus.INFO,"Browser Maximized");
//        WebForm webForm = new WebForm(driver);
//        webForm.enterUsername("");
//        test.log(LogStatus.INFO,"Input Empty Username");
//        Thread.sleep(1000);
//        webForm.enterPassword(webForm.PASSWORD);
//        test.log(LogStatus.INFO,"Input Password");
//        Thread.sleep(1000);
//        webForm.clickLogin();
//        test.log(LogStatus.INFO,"Click Login");
//        Thread.sleep(2000);
//        String messageText = driver.findElement(By.id("spanMessage")).getText();
//        System.out.println(messageText);
//        Assert.assertTrue(messageText.contains("Username cannot be empty"), "Text not found!");
//        test.log(LogStatus.INFO,"Text Verified");
//    }
//    @Test (testName = "Username and password are empty",priority = 5)
//    public void emptyboth() throws InterruptedException{
//        driver.get(Utils.BASE_URL);
//        driver.manage().window().maximize();
//        test.log(LogStatus.INFO,"Browser Maximized");
//        WebForm webForm = new WebForm(driver);
//        webForm.clickLogin();
//        test.log(LogStatus.INFO,"Click Login");
//        Thread.sleep(2000);
//        String messageText = driver.findElement(By.id("spanMessage")).getText();
//        System.out.println(messageText);
//        Assert.assertTrue(messageText.contains("Username cannot be empty"), "Text not found!");
//        test.log(LogStatus.INFO,"Text Verified");
//    }
//    @Test (testName = "Click Forgot Password",priority = 6)
//    public void forgotpassword() throws InterruptedException{
//        driver.get(Utils.BASE_URL);
//        driver.manage().window().maximize();
//        test.log(LogStatus.INFO,"Browser Maximized");
//        WebForm webForm = new WebForm(driver);
//        webForm.clickForgotpsw();
//        test.log(LogStatus.INFO,"Click Forgot Password");
//        Thread.sleep(5000);
//    }
//    @AfterClass
//    public void cleanUp(){
//        driver.manage().deleteAllCookies();
//        driver.close();

//    }
}
