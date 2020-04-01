package bcs.qa.community.pages;

import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    String searchFieldXpath = "//input[@id = 'searchInput']";
    String searchButtonXpath = "//button/i[text() = 'Search']";

    public void open() {
        driver.get("https://www.wikipedia.org/");
    }

    public void setSearchField(String searchQuery) {
        WebElement searchField = driver.findElementByXpath(searchFieldXpath);
        searchField.sendKeys(searchQuery);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElementByXpath(searchButtonXpath);
        searchButton.click();
    }
}