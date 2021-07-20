package testcase;


import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestForgotPasswordClickCancel extends OpenBrowser {

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
    @AfterClass
    public void cleanUps(){
        driver.manage().deleteAllCookies();
        driver.close();

    }

}
