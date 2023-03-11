package com.bsuir.calculator.controllers;

import com.bsuir.calculator.dto.RequestValueDTO;
import com.bsuir.calculator.dto.ResponseValueDTO;
import com.bsuir.calculator.loggers.GlobalLogger;
import com.bsuir.calculator.services.CalculationService;
import com.bsuir.calculator.services.RequestCounter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/calculator")
@Validated
public class CalculatorController {


    @Autowired
    CalculationService calculationService;

    @GetMapping("/calculate")
    public ResponseEntity<ResponseValueDTO> getCalculation(@RequestBody @Valid RequestValueDTO requestValueDTO) {
        GlobalLogger.logMessage("-------------------------------------------------");
        GlobalLogger.logMessage("Success accepted arguments");
        synchronized (this) {
            RequestCounter.requestSuccessAccepted();
            return new ResponseEntity<>(calculationService.calculateResult(requestValueDTO),HttpStatus.OK);
        }
    }

}
