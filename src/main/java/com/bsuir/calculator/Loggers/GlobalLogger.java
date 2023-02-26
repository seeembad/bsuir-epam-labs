package com.bsuir.calculator.Loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GlobalLogger {
    private static final Logger logger = LogManager.getLogger();

    public static void logMessage(String message) {
        logger.info(message);
    }
}
