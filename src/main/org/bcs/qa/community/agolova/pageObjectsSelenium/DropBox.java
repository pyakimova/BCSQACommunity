package agolova.pageObjectsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DropBox {
    static WebDriver driver;

    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\driver\\geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html");
        String mainWindow = driver.getWindowHandle();

        WebElement link = driver.findElement(By.xpath("//th//a[contains(., \"Oracle Technology Network License Agreement for Oracle Java SE\")]"));

        link.click();

        for(String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }

        WebElement button = driver.findElement(By.xpath("//a[contains(., \"Home\")]"));

        button.click();

        driver.switchTo().window(mainWindow);
        WebElement downloadButton = driver.findElement(By.xpath("//a[@href=\"/technetwork/java/javase/overview/index.html\"]"));
        downloadButton.click();

        System.out.println(downloadButton.getText());
        //Actions action = new Actions(driver);
        //action.click(downloadButton).build().perform();

        // action.moveToElement(element);
        // action.moveToElement(element).build().perform();
        //setPointInList("Показать");
        //setPointInList("КПП");
        //driver.quit();
    }

    public static void setPointInList(String name){
        String listName = "//button[contains(., \"%s\")]";
        driver.findElement(By.xpath(String.format(listName,name))).click();
    }
}
