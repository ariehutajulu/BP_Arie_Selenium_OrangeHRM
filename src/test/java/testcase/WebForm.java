package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WebForm extends PageObject {
    public final String USERNAME = "Admin";
    public final String PASSWORD = "s3Kol4HQA!*";

    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(id = "txtPassword")
    public WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement buttonLogin;

    @FindBy(id = "welcome")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//*[@id=\"forgotPasswordLink\"]/a")
    public WebElement forgotpsw;

    @FindBy(xpath = "//*[@id=\"securityAuthentication_userName\"]")
    public WebElement usernameinput;

    @FindBy(xpath = "//*[@id=\"btnSearchValues\"]")
    public WebElement buttonSearch;

    @FindBy(id = "btnCancel")
    public WebElement buttonCancel;

    public WebForm(WebDriver driver){
        super(driver);
    }
    public void enterUsername(String username){
        this.username.sendKeys(username);
    }
    public void enterPassword(String password){
        this.password.sendKeys(password);
    }
    public void clickLogin(){
        this.buttonLogin.click();
    }
    public void welcomeMsg(){
        this.welcomeMsg.click();
    }
    public void clickForgotpsw() { this.forgotpsw.click(); }
    public void setUsernameinput(String usernameinput1){this.usernameinput.sendKeys(usernameinput1);}
    public void clickResetPassword() { this.buttonSearch.click();}
    public void clickButtonCancel() {this.buttonCancel.click();}

}
