package com.bsuir.calculator.Services;

import com.bsuir.calculator.DTO.RequestValueDTO;
import com.bsuir.calculator.Loggers.GlobalLogger;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Service
public class CalculationService {

    @Cacheable(cacheNames = {"calculationResults"}, key = "#requestValueDTO")
    public HashMap<String, Boolean> calculateResult(RequestValueDTO requestValueDTO) {
        HashMap<String, Boolean> resultHashMap = new HashMap<>();
        resultHashMap.put("even", requestValueDTO.getValue() % 2 == 0);
        boolean isPrime = true;
        for (int i = 2; i < Math.sqrt(requestValueDTO.getValue()); i++) {
            if (requestValueDTO.getValue() % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println("Test branch");
        resultHashMap.put("prime", isPrime);
        GlobalLogger.logMessage("Success calculated result for argument");
        return resultHashMap;
    }
}
