package com.bsuir.calculator.services;

import com.bsuir.calculator.dto.RequestValueDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AverageCalculationService {
    public Map<String, Double> getAverage(List<RequestValueDTO> requestValueDTOList) {
        Map<String, Double> map = new HashMap<>();
        double average = 0;
        double min = requestValueDTOList.get(0).getValue();
        double max = requestValueDTOList.get(0).getValue();

        for (RequestValueDTO request: requestValueDTOList) {
            average += request.getValue();

            if (request.getValue() < min) {
                min = request.getValue();
            }

            if (request.getValue() > max) {
                max = request.getValue();
            }
        }

        map.put("average", average);
        map.put("max", max);
        map.put("min", min);
        return map;
    }
}
