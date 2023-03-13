package com.bsuir.calculator.services;

import com.bsuir.calculator.dto.RequestValueDTO;
import com.bsuir.calculator.dto.ResponseValueDTO;
import com.bsuir.calculator.loggers.GlobalLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalculationService {

    @Autowired
    CalculationServiceCache calculationServiceCache;

    public ResponseValueDTO calculateResult(RequestValueDTO requestValueDTO) {

        if (calculationServiceCache.isContainValue(requestValueDTO)) {
            GlobalLogger.logMessage("Result was got from cache.");
            return calculationServiceCache.getCachedValue(requestValueDTO);
        }

        boolean isEven = requestValueDTO.getValue() % 2 == 0;
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(requestValueDTO.getValue()); i++) {
            if (requestValueDTO.getValue() % i == 0) {
                isPrime = false;
                break;
            }
        }

        ResponseValueDTO responseValueDTO = new ResponseValueDTO(requestValueDTO.getValue(), isEven, isPrime);
        GlobalLogger.logMessage("Success calculated result for argument");
        calculationServiceCache.cachingValue(requestValueDTO, responseValueDTO);
        GlobalLogger.logMessage("Success cached value={" + requestValueDTO.getValue() + "}");
        return responseValueDTO;
    }
}
