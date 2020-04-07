package agolova2.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.Collection;
import com.codeborne.selenide.Condition;

public class Waiters {

    private Waiters() {

    }

    public static void waitElementsUntil(Condition selenideCondition, int timeout, SelenideElement... selenideElements) {
        Arrays.stream(selenideElements).forEach(e -> e.waitUntil(selenideCondition, timeout));
    }

    public static void waitElementsUntil(Condition selenideCondition, int timeout, Collection<SelenideElement> selenideElements) {
        selenideElements.forEach(e -> e.waitUntil(selenideCondition, timeout));
    }
}
