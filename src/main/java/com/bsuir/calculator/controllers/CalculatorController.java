package com.bsuir.calculator.controllers;

import com.bsuir.calculator.dto.RequestValueDTO;
import com.bsuir.calculator.dto.ResponseValueDTO;
import com.bsuir.calculator.loggers.GlobalLogger;
import com.bsuir.calculator.models.Result;
import com.bsuir.calculator.repositories.IResultRepository;
import com.bsuir.calculator.services.AverageCalculationService;
import com.bsuir.calculator.services.CalculationService;
import com.bsuir.calculator.services.RequestCounter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/calculator")
@Validated
public class CalculatorController {

    @Autowired
    AverageCalculationService averageCalculationService;

    @Autowired
    CalculationService calculationService;

    @Autowired
    IResultRepository iResultRepository;

    @GetMapping("/calculate")
    public ResponseEntity<ResponseValueDTO> getCalculation(@RequestBody @Valid RequestValueDTO requestValueDTO) {
        GlobalLogger.logMessage("-------------------------------------------------");
        GlobalLogger.logMessage("Success accepted arguments");
        synchronized (this) {
            RequestCounter.requestSuccessAccepted();
            iResultRepository.save(new Result(calculationService.calculateResult(requestValueDTO)));
            return new ResponseEntity<>(calculationService.calculateResult(requestValueDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> saveCalculation(@RequestBody @Valid RequestValueDTO requestValueDTO) {
        RequestCounter.requestSuccessAccepted();
        CompletableFuture.runAsync(() -> calculationService.saveResult(requestValueDTO));
        return new ResponseEntity<>("saveResult", HttpStatus.OK);
    }

    @GetMapping("/calculate/all")
    public ResponseEntity<List<ResponseValueDTO>> getAllCalculations() {
        RequestCounter.requestSuccessAccepted();
        return new ResponseEntity<>(calculationService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/calculate/all")
    public ResponseEntity<String> saveAllCalculations(
            @RequestBody @Valid List<RequestValueDTO> requestValueDTOS) {
        RequestCounter.requestSuccessAccepted();
        CompletableFuture.runAsync(() -> calculationService.saveAllResults(requestValueDTOS));
        return new ResponseEntity<>("saveAllResults", HttpStatus.OK);

    }

    @GetMapping("/calculate/average")
    public ResponseEntity<Map<String, Double>> averageCalculations(
            @RequestBody @Valid List<RequestValueDTO> requestValueDTOS) {
        RequestCounter.requestSuccessAccepted();
        return new ResponseEntity<>(averageCalculationService.getAverage(requestValueDTOS), HttpStatus.OK);

    }
}
