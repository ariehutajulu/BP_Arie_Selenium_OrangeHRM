package testcase;


import init.ExtentFactory;
import init.Utils;
import init.WebForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;

public class TestForgotPassword extends OpenBrowser {

    @Test (testName = "Input Correct Username Forgot Password",priority = 7)
    public void inputcorrect() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Forgot Password");
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput(webForm.USERNAME);
        test.log(LogStatus.PASS,"Input forgot username");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.PASS,"Click Reset");
        Thread.sleep(1000);
        String messageText = driver.findElement(By.xpath("//div[@class='message warning fadable']")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Password reset email could not be sent"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Input Incorrect Username Forgot Password",priority = 8)
    public void inputincorrect() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Forgot Password Incorrect Username");
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("Solo");
        test.log(LogStatus.PASS,"Input incorrect Username");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.PASS,"Click Reset Password");
        Thread.sleep(1000);
        String messageText = driver.findElement(By.xpath("//div[@class='message warning fadable']")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Please contact HR admin in order to reset the password"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Input empty Username Forgot Password",priority = 9)
    public void inputemptyforgot() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Forgot Password empty Username");
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("");
        test.log(LogStatus.PASS,"Input empty username");

        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.PASS,"Click reset password");
        Thread.sleep(1000);
        String messageText = driver.findElement(By.xpath("//div[@class='message warning fadable']")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Could not find a user with given details"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();

    }
    @Test (testName = "Click Cancel",priority = 10)
    public void clickcancel() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Click Cancel");
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.clickButtonCancel();
        test.log(LogStatus.PASS,"Click Cancel");

        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
        report.endTest(test);
        report.flush();
    }
}
