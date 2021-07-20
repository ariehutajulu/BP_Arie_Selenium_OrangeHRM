package testcase;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginInvalidPassword extends OpenBrowser{

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
}
