package testcase;


import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;

public class TestForgotPassword extends OpenBrowser {

    @Test (testName = "Input Correct Username Forgot Password",priority = 7)
    public void inputcorrect() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Forgot Password");
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput(webForm.USERNAME);
        test.log(LogStatus.PASS,"Input forgot username");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.PASS,"Click Reset");
        Thread.sleep(1000);
        //Belum bisa assert hidden text
        report.endTest(test);
        report.flush();
    }

}
