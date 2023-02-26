package com.bsuir.calculator.Controllers;

import com.bsuir.calculator.DTO.RequestValueDTO;
import com.bsuir.calculator.Loggers.GlobalLogger;
import com.bsuir.calculator.Services.CalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/calculator")
@Validated
public class CalculatorController {

    @Autowired
    CalculationService calculationService;

    @GetMapping("/calculate")
    public ResponseEntity<HashMap<String, Boolean>> getCalculation(@RequestBody @Valid RequestValueDTO requestValueDTO) {
        GlobalLogger.logMessage("Success accepted arguments");
        return new ResponseEntity<>(calculationService.calculateResult(requestValueDTO),HttpStatus.ACCEPTED);
    }
}
