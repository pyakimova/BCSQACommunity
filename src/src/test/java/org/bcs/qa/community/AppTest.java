package org.bcs.qa.community;

import io.qameta.allure.Step;
import org.junit.Test;

public class AppTest {

    @Test
    public void firstTestMethod() {
        firstStep();
    }

    @Step
    public void firstStep() {
        secondStep();
    }

    @Step
    public void secondStep() {
    }
}
