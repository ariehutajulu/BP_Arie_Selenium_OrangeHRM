package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import testcase.OpenBrowser;

public class PageObject extends OpenBrowser {
    public WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}