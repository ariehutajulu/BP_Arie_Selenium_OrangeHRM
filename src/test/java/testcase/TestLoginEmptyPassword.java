package testcase;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginEmptyPassword extends OpenBrowser{

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
}
