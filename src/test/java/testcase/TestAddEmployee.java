package testcase;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddEmployee extends TestLogin {

    @Test (testName = "Add Employee",priority = 12)
    public void addEmployee() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Add Employee");
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"Browser Maximized");
        //Move To PIM
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.id("menu_pim_viewPimModule"));
        builder.moveToElement(element).build().perform();
        test.log(LogStatus.PASS,"Mouse over to PIM");
        Thread.sleep(1000);
        //Click Add Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        test.log(LogStatus.PASS,"Click Add Employee");
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys("Arie");
        test.log(LogStatus.PASS,"Input First Name");
        driver.findElement(By.id("middleName")).sendKeys("Ebeth");
        test.log(LogStatus.PASS,"Input Middle Name");
        driver.findElement(By.id("lastName")).sendKeys("Hutajulu");
        test.log(LogStatus.PASS,"Input Last Name");
        WebElement uploadElement = driver.findElement(By.id("photofile"));
        uploadElement.sendKeys("C:\\Users\\arieh\\Pictures\\Screenshots\\Screenshot (4).png");
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Upload Profile Picture");
        driver.findElement(By.id("btnSave")).click();
        test.log(LogStatus.PASS,"Employee Added");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Add Employee No Middle name",priority = 13)
    public void noMidName() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Add Employee No MidName");
        driver.manage().window().maximize();
        //Move To PIM
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.id("menu_pim_viewPimModule"));
        builder.moveToElement(element).build().perform();
        Thread.sleep(1000);
        test.log(LogStatus.PASS,"Mouse over PIM");
        //Click Add Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Click Add Employee");
        driver.findElement(By.id("firstName")).sendKeys("Arie");
        test.log(LogStatus.PASS,"Input First Name");
        driver.findElement(By.id("lastName")).sendKeys("Hutajulu");
        test.log(LogStatus.PASS,"Input Last Name");
        WebElement uploadElement = driver.findElement(By.id("photofile"));
        uploadElement.sendKeys("C:\\Users\\arieh\\Pictures\\Screenshots\\Screenshot (4).png");
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Upload Profile Picture");
        driver.findElement(By.id("btnSave")).click();
        test.log(LogStatus.PASS,"Click Button Save");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Add Employee No First name",priority = 14)
    public void noFirstName() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Add Employee No First Name");
        driver.manage().window().maximize();
        //Move To PIM
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.id("menu_pim_viewPimModule"));
        builder.moveToElement(element).build().perform();
        test.log(LogStatus.PASS,"Mouse over PIM");
        Thread.sleep(1000);
        //Click Add Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        test.log(LogStatus.PASS,"Click Add Employee");
        Thread.sleep(2000);
        driver.findElement(By.id("middleName")).sendKeys("Ebeth");
        test.log(LogStatus.PASS,"Input Middle Name");
        driver.findElement(By.id("lastName")).sendKeys("Hutajulu");
        test.log(LogStatus.PASS,"Input Last Name");

        WebElement uploadElement = driver.findElement(By.id("photofile"));
        uploadElement.sendKeys("C:\\Users\\arieh\\Pictures\\Screenshots\\Screenshot (4).png");
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Upload Profile Picture");
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(1000);
        test.log(LogStatus.PASS,"Click Save Button");
        String msgfirstname = driver.findElement(By.xpath("//span[@class='validation-error']")).getText();
        System.out.println(msgfirstname);
        Assert.assertTrue(msgfirstname.contains("Required"), "Text not found!");
        test.log(LogStatus.PASS,"Verify Text Validation Error 'Required'");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Add Employee No Last name",priority = 15)
    public void noLastName() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Add Employee No Last Name");
        driver.manage().window().maximize();
        //Move To PIM
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.id("menu_pim_viewPimModule"));
        builder.moveToElement(element).build().perform();
        Thread.sleep(1000);
        test.log(LogStatus.PASS,"Mouse over PIM");
        //Click Add Employee
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Click Add Employee");
        driver.findElement(By.id("firstName")).sendKeys("Arie");
        test.log(LogStatus.PASS,"Input First Name");
        driver.findElement(By.id("middleName")).sendKeys("Ebeth");
        test.log(LogStatus.PASS,"Input Middle Name");

        WebElement uploadElement = driver.findElement(By.id("photofile"));
        uploadElement.sendKeys("C:\\Users\\arieh\\Pictures\\Screenshots\\Screenshot (4).png");
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Upload Profile Picture");
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(1000);
        test.log(LogStatus.PASS,"Click Save Button");
        String msgfirstname = driver.findElement(By.xpath("//span[@class='validation-error']")).getText();
        System.out.println(msgfirstname);
        Assert.assertTrue(msgfirstname.contains("Required"), "Text not found!");
        test.log(LogStatus.PASS,"Verify Text Validation Error 'Required'");
        report.endTest(test);
        report.flush();
    }

}
