package samsonova.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class GoogleResultsPage {
    @FindBy(how = How.CSS, using = "#ires li.g")
    public ElementsCollection results;
}
