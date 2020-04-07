package org.bcs.qa.community.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    private static Logger log = null;

    public static Logger getInstance() {
        if (log == null) {
            log = LogManager.getLogger();
        }
        return log;
    }

    private MyLogger() {
    }
}