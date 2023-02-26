package com.bsuir.calculator.Services;


import com.bsuir.calculator.DTO.RequestValueDTO;
import com.bsuir.calculator.DTO.ResponseValueDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CalculationServiceCache {
    private final HashMap<Integer, ResponseValueDTO> cacheHashMap = new HashMap<>();

    public boolean isContainValue(RequestValueDTO requestValueDTO) {
        return cacheHashMap.containsKey(requestValueDTO.getValue());
    }

    public void cachingValue(RequestValueDTO requestValueDTO, ResponseValueDTO responseValueDTO) {
        cacheHashMap.put(requestValueDTO.getValue(), responseValueDTO);
        System.out.println(cacheHashMap);
    }

    public ResponseValueDTO getCachedValue(RequestValueDTO requestValueDTO) {
        return cacheHashMap.get(requestValueDTO.getValue());
    }
}
