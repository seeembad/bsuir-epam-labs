package com.bsuir.calculator.services;


import com.bsuir.calculator.dto.RequestValueDTO;
import com.bsuir.calculator.dto.ResponseValueDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CalculationServiceCache {
    private final Map<Integer, ResponseValueDTO> cacheHashMap = new HashMap<>(); // default map

    public boolean isContainValue(RequestValueDTO requestValueDTO) {
        return cacheHashMap.containsKey(requestValueDTO.getValue());
    }

    public void cachingValue(RequestValueDTO requestValueDTO, ResponseValueDTO responseValueDTO) {
        cacheHashMap.put(requestValueDTO.getValue(), responseValueDTO);
    }

    public ResponseValueDTO getCachedValue(RequestValueDTO requestValueDTO) {
        return cacheHashMap.get(requestValueDTO.getValue());
    }
}
