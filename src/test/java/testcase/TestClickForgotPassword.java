package testcase;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClickForgotPassword extends OpenBrowser{

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
