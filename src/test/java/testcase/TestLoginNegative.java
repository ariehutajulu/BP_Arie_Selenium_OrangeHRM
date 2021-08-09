package testcase;


import com.relevantcodes.extentreports.LogStatus;
import init.ExtentFactory;
import init.Utils;
import init.WebForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginNegative extends OpenBrowser{

    @Test(testName = "Login Invalid Username",priority = 1)
    public void submitinvalid() throws InterruptedException{
        report= ExtentFactory.getInstance();
        test = report.startTest("Test case Invalid Username");
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername("adam");
        test.log(LogStatus.PASS,"Input wrong/invalid Username");
        Thread.sleep(1000);
        webForm.enterPassword(webForm.PASSWORD);
        test.log(LogStatus.PASS,"Input Password");
        Thread.sleep(1000);
        webForm.clickLogin();
        test.log(LogStatus.PASS,"Click Login");
        Thread.sleep(1000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Invalid credentials"), "Text not found!");
        test.log(LogStatus.PASS,"Text verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Login Invalid password",priority = 2)
    public void submitinvalidpassword() throws InterruptedException{
        report= ExtentFactory.getInstance();
        test = report.startTest("Test case Invalid Password");
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        test.log(LogStatus.PASS,"Input Username");
        Thread.sleep(1000);
        webForm.enterPassword("sekolahkie");
        test.log(LogStatus.PASS,"Input Invalid password");
        Thread.sleep(1000);
        webForm.clickLogin();
        Thread.sleep(1000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Invalid credentials"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Login empty password",priority = 3)
    public void submitemptypassword() throws InterruptedException{

        report= ExtentFactory.getInstance();
        test = report.startTest("Test case Empty Password");
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        test.log(LogStatus.PASS,"Input Username");
        Thread.sleep(1000);
        webForm.enterPassword("");
        test.log(LogStatus.PASS, "Input empty password");
        Thread.sleep(1000);
        webForm.clickLogin();
        test.log(LogStatus.PASS,"Click Login");
        Thread.sleep(2000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Password cannot be empty"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Login empty username",priority = 4)
    public void submitemptyusername() throws InterruptedException{
        report= ExtentFactory.getInstance();
        test = report.startTest("Test case Empty Username");
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername("");
        test.log(LogStatus.PASS,"Input Empty Username");
        Thread.sleep(1000);
        webForm.enterPassword(webForm.PASSWORD);
        test.log(LogStatus.PASS,"Input Password");
        Thread.sleep(1000);
        webForm.clickLogin();
        test.log(LogStatus.PASS,"Click Login");
        Thread.sleep(2000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Username cannot be empty"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Username and password are empty",priority = 5)
    public void emptyboth() throws InterruptedException{
        report= ExtentFactory.getInstance();
        test = report.startTest("Test case Empty Both Password and Username");
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.clickLogin();
        test.log(LogStatus.PASS,"Click Login");
        Thread.sleep(2000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Username cannot be empty"), "Text not found!");
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Click Forgot Password",priority = 6)
    public void forgotpassword() throws InterruptedException{
        report= ExtentFactory.getInstance();
        test = report.startTest("Test Click Forgot Password");
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.clickForgotpsw();
        test.log(LogStatus.PASS,"Click Forgot Password");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
        test.log(LogStatus.PASS,"Text Verified");
        report.endTest(test);
        report.flush();
    }
}
