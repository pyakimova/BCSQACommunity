package bcs.qa.community.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {

    String articleNameXpath = "//h1[@id = 'firstHeading']";

    public void checkArticleeNameIsPresent(String articleName) {
        WebElement articleHeader = driver.findElementByXpath(articleNameXpath);
        Assert.assertEquals(articleHeader.getText(), articleName);
    }
}