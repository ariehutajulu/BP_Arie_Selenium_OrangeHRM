package testcase;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginInvalidUsername extends OpenBrowser{

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
}
