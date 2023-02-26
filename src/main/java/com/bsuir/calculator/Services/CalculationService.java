package com.bsuir.calculator.Services;

import com.bsuir.calculator.DTO.RequestValueDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CalculationService {
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

        resultHashMap.put("prime", isPrime);

        return resultHashMap;
    }
}
