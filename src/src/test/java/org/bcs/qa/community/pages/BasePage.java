package org.bcs.qa.community.pages;

import org.apache.logging.log4j.Logger;
import org.bcs.qa.community.WDriver;
import org.bcs.qa.community.util.MyLogger;

public class BasePage {
    WDriver driver = WDriver.getInstance();
    Logger log = MyLogger.getInstance();

    public void maximise() {
        driver.maximise();
    }

    public void close() {
        driver.close();
    }
}
