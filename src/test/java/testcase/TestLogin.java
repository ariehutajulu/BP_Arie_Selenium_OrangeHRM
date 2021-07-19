package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin {
    static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }

    @Test (testName = "Login Valid data",priority = 0)
    public static void submitvalid() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        Thread.sleep(2000);
        webForm.enterPassword(webForm.PASSWORD);
        Thread.sleep(2000);
        webForm.clickLogin();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Welcome Karyawan"));
    }
    @Test (testName = "Login Invalid Username",priority = 1)
    public static void submitinvalid() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername("adam");
        Thread.sleep(1000);
        webForm.enterPassword(webForm.PASSWORD);
        Thread.sleep(1000);
        webForm.clickLogin();
        Thread.sleep(1000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Invalid credentials"), "Text not found!");
    }
    @Test (testName = "Login Invalid password",priority = 2)
    public static void submitinvalidpassword() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        Thread.sleep(1000);
        webForm.enterPassword("sekolahkie");
        Thread.sleep(1000);
        webForm.clickLogin();
        Thread.sleep(1000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Invalid credentials"), "Text not found!");
    }
    @Test (testName = "Login empty password",priority = 3)
    public static void submitemptypassword() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername(webForm.USERNAME);
        Thread.sleep(1000);
        webForm.enterPassword("");
        Thread.sleep(1000);
        webForm.clickLogin();
        Thread.sleep(2000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Password cannot be empty"), "Text not found!");
    }
    @Test (testName = "Login empty username",priority = 4)
    public static void submitemptyusername() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.enterUsername("");
        Thread.sleep(1000);
        webForm.enterPassword(webForm.PASSWORD);
        Thread.sleep(1000);
        webForm.clickLogin();
        Thread.sleep(2000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Username cannot be empty"), "Text not found!");
    }
    @Test (testName = "Username and password are empty",priority = 5)
    public static void emptyboth() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.clickLogin();
        Thread.sleep(2000);
        String messageText = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Username cannot be empty"), "Text not found!");
    }
    @Test (testName = "Click Forgot Password",priority = 6)
    public static void forgotpassword() throws InterruptedException{
        driver.get(Utils.BASE_URL);
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);
        webForm.clickForgotpsw();
        Thread.sleep(5000);
    }
    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
