package testcase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class OpenBrowser {
    public static WebDriver driver ;
    public ExtentReports report;
    public ExtentTest test;

@BeforeSuite
    public void before(){
    System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    driver = new ChromeDriver();
}
}


