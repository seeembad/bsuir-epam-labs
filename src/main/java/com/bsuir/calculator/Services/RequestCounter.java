package com.bsuir.calculator.Services;

import com.bsuir.calculator.Loggers.GlobalLogger;
import org.springframework.stereotype.Service;

@Service
public class RequestCounter {
    private static int requestsAccepted = 0;

    synchronized public static void requestSuccessAccepted() {
        requestsAccepted++;
        GlobalLogger.logMessage("requestSuccessAccepted");
    }

    synchronized public static int getRequestsAccepted() {
        return requestsAccepted;
    }
}
