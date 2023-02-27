package com.bsuir.calculator.Controllers;

import com.bsuir.calculator.Loggers.GlobalLogger;
import com.bsuir.calculator.Services.RequestCounter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/calculator")
public class RequestsController {

    @GetMapping("/counter")
    public ResponseEntity<HashMap<String, Integer>> RequestCounter() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("requestsAccepted", RequestCounter.getRequestsAccepted());

        GlobalLogger.logMessage("RequestCounter Controller.");
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
