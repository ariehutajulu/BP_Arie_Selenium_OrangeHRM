package testcase;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TestSupport extends TestLogin {


    @Test (testName = "Click Icon Support",priority = 21)
    public void clickIconSupport() throws InterruptedException{

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Click Icon Support");

        driver.findElement(By.xpath("//a[@class='help-icon-div']")).click();
        test.log(LogStatus.PASS,"Click Support");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("http://qa.cilsy.id/symfony/web/index.php/help"), "Link Incorrect!");
        test.log(LogStatus.PASS,"Check/Verify URL");
        String updated = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]")).getText();
        System.out.println(updated);
        Assert.assertTrue(updated.contains("Help & Support"), "Nope!");
        test.log(LogStatus.PASS,"Check Head Page Text");
        Thread.sleep(1000);
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Click Play Store",priority = 22)
    public void clickPlayStore() throws InterruptedException{

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Click Play Store");
        driver.findElement(By.xpath("//img[@class='play-store-img']")).click();

        test.log(LogStatus.PASS,"Click Image Play Store");
        //switch to new tab
        Thread.sleep(1000);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        Thread.sleep(1000);
        driver.switchTo().window(newTb.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());
        test.log(LogStatus.PASS,"Go To next Tab");
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM Open Source - Apps on Google Play"));
        Thread.sleep(1000);
        test.log(LogStatus.PASS,"Verify Title");
        driver.close();
        //switch to parent window
        driver.switchTo().window(newTb.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Click App Store",priority = 23)
    public void clickAppStore() throws InterruptedException{

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Click App Store");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@class='app-store-img']")).click();
        test.log(LogStatus.PASS,"Click Icon App Store");
        //switch to new tab
        Thread.sleep(1000);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        Thread.sleep(1000);
        driver.switchTo().window(newTb.get(1));
        test.log(LogStatus.PASS,"Go To Next Tab");
        Thread.sleep(1000);
        System.out.println("Page title of new tab: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("\u200EOrangeHRM Open Source on the App Store"));
        Thread.sleep(1000);
        //switch to parent window
        driver.switchTo().window(newTb.get(0));
        test.log(LogStatus.PASS,"Verify Title of the window");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Logout",priority = 24)
    public void Logout() throws InterruptedException{

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Logout");
        Thread.sleep(1000);
        driver.findElement(By.id("welcome")).click();
        test.log(LogStatus.PASS,"Click Icon Profile");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/symfony/web/index.php/auth/logout']")).click();
        test.log(LogStatus.PASS,"Click Logout");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
        test.log(LogStatus.PASS,"Verify Title of the window");
        report.endTest(test);
        report.flush();
        driver.quit();
    }


}
