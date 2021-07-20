package testcase;


import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestForgotPasswordEmptyUsername extends OpenBrowser {

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
        report.endTest(test);
        report.flush();
        //Belum bisa assert hidden text
    }

}
