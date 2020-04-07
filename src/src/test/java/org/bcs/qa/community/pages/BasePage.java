package bcs.qa.community.pages;

import bcs.qa.community.WDriver;
import bcs.qa.community.util.MyLogger;
import org.apache.logging.log4j.Logger;

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
