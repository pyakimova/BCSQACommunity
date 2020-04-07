package org.bcs.qa.community;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.bcs.qa.community.util.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class WDriver {
    private static WDriver instance;
    private static ChromeDriver driver;
    private static Logger log = MyLogger.getInstance();
    private static WebDriverWait wait;

    private WDriver() {
        log.debug("Запускаю сервис вебдрайвера");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver",
                "C:\\temp6\\BCS\\src\\bin\\chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10, 250);
    }

    public static WDriver getInstance() {
        if (instance == null) {
            instance = new WDriver();
        }
        return instance;
    }

    public WebElement findElementByXpath(String xpath) {
        log.debug(String.format("Ищу элемент по локатору '%s'",
                xpath));
        WebElement element = null;
        for (int i = 0; i < 5; i++) {
            try {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                return element;
            } catch (Exception e) {
                log.warn(String.format("Элемент не был найден. Попытка '%d'", i));
                continue;
            }
        }
        log.error(String.format("Элемент не был найден. xpath '%s'", xpath));
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            long time = System.currentTimeMillis();
            FileUtils.copyFile(file, new File(String.format("screenshots/%d.jpg", time)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public void get(String url) {
        log.debug(String.format("Открываем страницу по адресу '%s'", url));
        driver.get(url);
    }

    public void maximise() {
        log.debug("Разворачиваю окно на полный экран");
        driver.manage().window().maximize();
    }

    public void close() {
        log.debug("Закрываю текущую вкладку");
        driver.close();
    }

}
