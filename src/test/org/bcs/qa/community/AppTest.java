package org.bcs.qa.community;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void CheckGoogle(){
        open("https://google.com");
    }

    @Test
    public void userCanSearchAnyKeyword() {
        open("https://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(5));
        $("#res .g").shouldHave(text("selenide.org"));
    }
}
