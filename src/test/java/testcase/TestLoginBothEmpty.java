package testcase;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginBothEmpty extends OpenBrowser{

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
}
