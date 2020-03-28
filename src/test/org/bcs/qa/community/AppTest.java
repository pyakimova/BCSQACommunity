package org.bcs.qa.community;

import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Test;

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
}
