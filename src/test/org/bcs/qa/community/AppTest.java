package org.bcs.qa.community;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

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
