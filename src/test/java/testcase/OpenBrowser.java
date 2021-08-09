package testcase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import init.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


public class OpenBrowser {
    public static WebDriver driver ;
    public ExtentReports report;
    public ExtentTest test;

@BeforeSuite
    public void before(){
    System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    driver = new ChromeDriver();
}
}


