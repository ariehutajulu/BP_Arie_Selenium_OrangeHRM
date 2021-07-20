package testcase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class OpenBrowser {

    static WebDriver driver = new ChromeDriver();
    ExtentReports report;
    ExtentTest test;
    @BeforeClass
    public void beforeclass() {
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);

    }
}
