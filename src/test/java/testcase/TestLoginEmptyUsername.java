package testcase;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginEmptyUsername extends OpenBrowser{

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
}
