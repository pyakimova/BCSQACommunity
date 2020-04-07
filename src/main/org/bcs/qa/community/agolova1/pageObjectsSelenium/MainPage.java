package agolova2.pageObjectsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage{

    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[contains(.,\"Sign\") and contains(., \"in\")]");
    private By signUpButton = By.xpath("//a[contains(.,\"Sign\") and contains(., \"up\")]");
    private By userLoginInput = By.id("user[login]");
    private By userEmailInput = By.id("user[email]");
    private By userPasswordInput = By.id("user[password]");
    private By signUpButtonInForm = By.xpath("//button[contains(.,\"Sign up for GitHub\")]");

    public agolova2.pageObjectsSelenium.LoginPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new agolova2.pageObjectsSelenium.LoginPage(driver);
    }

    public agolova2.pageObjectsSelenium.SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new agolova2.pageObjectsSelenium.SignUpPage(driver);
    }

    public agolova2.pageObjectsSelenium.SignUpPage clickSignUpBettonInForm(){
        driver.findElement(signUpButtonInForm).click();
        return new agolova2.pageObjectsSelenium.SignUpPage(driver);
    }

    public MainPage inputLogin(String username){
        driver.findElement(userLoginInput).sendKeys(username);
        return this;
    }

    public MainPage inputUserEmailInput(String email){
        driver.findElement(userEmailInput).sendKeys(email);
        return this;
    }

    public MainPage inputUserPasswordInput(String password){
        driver.findElement(userPasswordInput).sendKeys(password);
        return this;
    }

    public agolova2.pageObjectsSelenium.SignUpPage registre(String username, String email, String password){
        this.inputLogin(username);
        this.inputUserEmailInput(email);
        this.inputUserPasswordInput(password);
        this.clickSignUpBettonInForm();
        return new agolova2.pageObjectsSelenium.SignUpPage(driver);
    }

}
