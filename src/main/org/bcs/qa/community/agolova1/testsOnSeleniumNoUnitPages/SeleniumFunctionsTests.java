package testsOnSeleniumNoUnitPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumFunctionsTests {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sasib\\OneDrive\\Documents\\GitHub\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //время ожидание каждого элемента до появления
        driver.manage().window().maximize();

        // driver.manage().window().setSize(new Dimension(800, 600));


        //работа с сайтом Google
        /* driver.get("https://google.com/");
        driver.navigate().to("https://selenium.dev/");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        WebElement element = driver.findElement(By.xpath("//a[@class='nav-item' and contains(., \"Support\")]"));
        if (element.getText().equals("Support")){
            System.out.println("Successful");
        }
        else{
            System.out.println("Failed");
        }
            element.click();


       //работа с сайтом WikiHow
       driver.get("https://ru.wikihow.com/");
       WebElement fieldInput = driver.findElement(By.xpath("//form[@id=\"bubble_search\"]//child::input[@class=\"search_box\"]"));
       fieldInput.sendKeys("How to develope in Java");
       WebElement findButton = driver.findElement(By.className("search_button"));
       findButton.click();
       System.out.println(driver.findElement(By.xpath("//form[@id=\"bubble_search\"]//child::input[@class=\"search_box\"]")).getAttribute("placeholder"));
       WebElement logoLink = driver.findElement(By.id("logo_link"));
       System.out.println(logoLink.getText());
       logoLink.click(); */


        //работа с сайтом ЯндексМаркет
        driver.get("https://market.yandex.ru");
        driver.navigate().refresh();
        WebElement nextButton1 = driver.findElement(By.xpath("//a[@class=\"_3Lwc_UVFq4\"]//child::span[contains(., \"Бытовая техника\")]"));
        nextButton1.click();
        WebElement nextButton2 = driver.findElement(By.xpath("//a[contains(., \"Стиральные машины\")]"));
        nextButton2.click();
        selectCheckBox("ATLANT");
        selectCheckBox("Beko");
        driver.quit(); //закрываем браузер
    }

    public static void selectCheckBox(String name) {
        String cbxXpath = "//input[@name = \"Производитель %s\"]//parent::label";
        if (!driver.findElement(By.xpath(String.format(cbxXpath, name) + "//parent::label")).isSelected()){
            driver.findElement(By.xpath(String.format(cbxXpath, name))).click();
        }
    }
}
