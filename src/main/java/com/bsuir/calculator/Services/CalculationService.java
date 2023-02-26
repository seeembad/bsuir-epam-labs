package com.bsuir.calculator.Services;

import com.bsuir.calculator.DTO.RequestValueDTO;
import com.bsuir.calculator.DTO.ResponseValueDTO;
import com.bsuir.calculator.Loggers.GlobalLogger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CalculationService {

    @Cacheable(cacheNames = {"calculationResults"}, key = "#requestValueDTO.value")
    public ResponseValueDTO calculateResult(RequestValueDTO requestValueDTO) {
        try {
            TimeUnit.SECONDS.sleep(3L);
            boolean isEven = requestValueDTO.getValue() % 2 == 0;
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(requestValueDTO.getValue()); i++) {
                if (requestValueDTO.getValue() % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            GlobalLogger.logMessage("Success calculated result for argument");
            return new ResponseValueDTO(requestValueDTO.getValue(), isEven, isPrime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
