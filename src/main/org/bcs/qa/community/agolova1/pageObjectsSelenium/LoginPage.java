package agolova2.pageObjectsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//input[contains(@value, \"Sign in\")]");
    private By headText = By.xpath("//div[contains(@class, \"auth-form-header p-0\")]");
    private By incorrectLofinText = By.xpath("//div[contains(@class, \"flash flash-full flash-error\")]");
    private By createAnAccountButton = By.xpath("/*[@id=\"login\"]/p/a");

    public LoginPage typeLogin(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage incorrectLoging(String username, String password) {
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);

    }

    public String getHeadText(){
        return driver.findElement(headText).getText();
    }

    public String getErrorText(){
        return driver.findElement(incorrectLofinText).getText();
    }

    public agolova2.pageObjectsSelenium.SignUpPage creatingAnAccount(){
        driver.findElement(createAnAccountButton).click();
        return new agolova2.pageObjectsSelenium.SignUpPage(driver);
    }

}
