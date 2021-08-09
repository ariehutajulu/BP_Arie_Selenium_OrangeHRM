package testcase;


import com.relevantcodes.extentreports.LogStatus;
import init.ExtentFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TestBuzz extends TestLogin {


    @Test (testName = "Go To Buzz",priority = 16)
    public void goToBuzz() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Goto Buzz");
        driver.findElement(By.id("menu_buzz_viewBuzz")).click();
        test.log(LogStatus.PASS,"Click Menu Buzz");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("http://qa.cilsy.id/symfony/web/index.php/buzz/viewBuzz"), "Link Incorrect!");
        test.log(LogStatus.PASS,"Check URL");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Update Status",priority = 17)
    public void updatestatus() throws InterruptedException{
        report = ExtentFactory.getInstance();
        test = report.startTest("Test case Update Status on Buzz");
        Thread.sleep(1000);
        String statusupdate = "Apakah anda mungkin?";
        driver.findElement(By.id("createPost_content")).sendKeys(statusupdate);
        test.log(LogStatus.PASS,"Input Status");
        driver.findElement(By.id("postSubmitBtn")).click();
        test.log(LogStatus.PASS,"Click Submit/Post");
        Thread.sleep(2000);
        String updated = driver.findElement(By.xpath("//div[@id='buzzContainer']//div[1]//div[@class='postContent']")).getText();
        System.out.println(updated);
        Assert.assertEquals(statusupdate,updated, "Nope!");
        test.log(LogStatus.PASS,"Verivy/Check Newest Status");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Upload Images",priority = 18)
    public void uploadimages() throws InterruptedException, AWTException {

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Case Upload Image on Buzz");


        //Move To PIM
        driver.findElement(By.id("images-tab-label")).click();
        test.log(LogStatus.PASS,"Click menu Update Image");
        Thread.sleep(1000);
        String gambarupload = "Apakah gambar ini mungkin?";
        driver.findElement(By.id("phototext")).sendKeys(gambarupload);
        test.log(LogStatus.PASS,"Input Caption on Picture");
        driver.findElement(By.id("image-upload-button")).click();
        Thread.sleep(1000);
        StringSelection ss = new StringSelection("C:\\Users\\arieh\\Pictures\\Screenshots\\Screenshot (4).png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(1);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(1);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(4000);
        driver.findElement(By.id("imageUploadBtn")).click();
        Thread.sleep(3000);
        test.log(LogStatus.PASS,"Image Posted");
        String uplodedpic = driver.findElement(By.xpath("//ul[@id='buzz']//li[1]//div[@class='postContent']")).getText();
        System.out.println(uplodedpic);
        Assert.assertEquals(gambarupload,uplodedpic, "Nope!");
        test.log(LogStatus.PASS,"Verify Status Text Equals ");
        report.endTest(test);
        report.flush();
    }
    @Test (testName = "Share Video",priority = 19)
    public void sharevideo() throws InterruptedException, AWTException {

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Share Video On Buzz");



        driver.findElement(By.id("video-tab-label")).click();
        test.log(LogStatus.PASS,"Click Upload Video");
        Thread.sleep(1000);
        driver.findElement(By.id("createVideo_content")).click();
        test.log(LogStatus.PASS,"Click area link video");
        Thread.sleep(1000);
        StringSelection sharelink = new StringSelection("https://www.youtube.com/watch?v=rirMN72XDr0&t=875s");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sharelink, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(1);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Link paste");
        driver.findElement(By.xpath("//input[@class='submitBtn btnSaveVideo']")).click();
        test.log(LogStatus.PASS,"Click Save Video");
        Thread.sleep(2000);
        String savevideo = driver.findElement(By.xpath("//ul[@id='buzz']//li[1]//div[@class='postContent']")).getText();
        System.out.println(savevideo);
        Assert.assertTrue(savevideo.contains("https://www.youtube.com/watch?v=rirMN72XDr0&t=875s"));
        test.log(LogStatus.PASS,"Verify Text Status/New Video link");

        report.endTest(test);
        report.flush();
    }


    @Test (testName = "Share Video Negative",priority = 20)
    public void sharevideonegative() throws InterruptedException, AWTException {

        report = ExtentFactory.getInstance();
        test = report.startTest("Test Share Video not video link");


        driver.findElement(By.id("video-tab-label")).click();
        test.log(LogStatus.PASS,"Click Upload Video");
        Thread.sleep(1000);
        driver.findElement(By.id("createVideo_content")).click();
        test.log(LogStatus.PASS,"Click area link Video");
        Thread.sleep(1000);
        StringSelection sharelink = new StringSelection("facebook.com");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sharelink, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(1);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(1000);
        test.log(LogStatus.PASS,"Invalid link paste");
        String savevideon = driver.findElement(By.xpath("//*[@id=\"errorMessageDiv\"]/div")).getText();
        System.out.println(savevideon);
        Assert.assertTrue(savevideon.contains("This url is not a valid url of a video or it is not supported by the system"));
        test.log(LogStatus.PASS,"Verify Error Message");
        report.endTest(test);
        report.flush();
    }
}
