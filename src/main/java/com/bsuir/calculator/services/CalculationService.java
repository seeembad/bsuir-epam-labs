package com.bsuir.calculator.services;

import com.bsuir.calculator.dto.RequestValueDTO;
import com.bsuir.calculator.dto.ResponseValueDTO;
import com.bsuir.calculator.loggers.GlobalLogger;
import com.bsuir.calculator.models.Result;
import com.bsuir.calculator.repositories.IResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CalculationService {

    @Autowired
    CalculationServiceCache calculationServiceCache;

    @Autowired
    IResultRepository repository;

    public ResponseValueDTO calculateResult(RequestValueDTO requestValueDTO) {
        if (calculationServiceCache.isContainValue(requestValueDTO)) {
            GlobalLogger.logMessage("Result was got from cache.");
            return calculationServiceCache.getCachedValue(requestValueDTO);
        }

        if (repository.existsById(requestValueDTO.getValue())) {
            GlobalLogger.logMessage("Result was got from DB");
            return new ResponseValueDTO(repository.getReferenceById(requestValueDTO.getValue()));
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

    public void saveResult(RequestValueDTO requestValueDTO) {
        repository.save(new Result(calculateResult(requestValueDTO)));
    }

    public List<ResponseValueDTO> getAll() {
        List<ResponseValueDTO> list = new ArrayList<>();
        repository.findAll().forEach(obj -> list.add(new ResponseValueDTO(obj)));

        return list;
    }

    public void saveAllResults(List<RequestValueDTO> requestValueDTOS) {
        requestValueDTOS.forEach(this::saveResult);
    }
}
