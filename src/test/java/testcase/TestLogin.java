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
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        test.log(LogStatus.PASS,"Input Username");

        Thread.sleep(2000);
        webForm.enterPassword(webForm.PASSWORD);
        test.log(LogStatus.PASS,"Input Password");
        Thread.sleep(2000);
        webForm.clickLogin();
        test.log(LogStatus.PASS,"Click Login");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Welcome Karyawan"));
        test.log(LogStatus.PASS,"Text Verified");

        report.endTest(test);
        report.flush();
    }

}
