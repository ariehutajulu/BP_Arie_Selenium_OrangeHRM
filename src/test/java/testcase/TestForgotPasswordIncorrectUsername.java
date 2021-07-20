package testcase;


import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;

public class TestForgotPasswordIncorrectUsername extends OpenBrowser {

    @Test (testName = "Input Incorrect Username Forgot Password" )
    public void inputincorrect() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Forgot Password Incorrect Username");
        driver.get(Utils.FORGOT_URL);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        WebForm webForm = new WebForm(driver);
        webForm.setUsernameinput("Solo");
        test.log(LogStatus.PASS,"Input incorrect Username");
        Thread.sleep(2000);
        webForm.clickResetPassword();
        test.log(LogStatus.PASS,"Click Reset Password");
        Thread.sleep(1000);
        //Belum bisa assert hidden text
        report.endTest(test);
        report.flush();
    }
}
