package com.bsuir.calculator;

import com.bsuir.calculator.DTO.RequestValueDTO;
import com.bsuir.calculator.DTO.ResponseValueDTO;
import com.bsuir.calculator.Services.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

@SpringBootTest
class CalculatorApplicationTests {

    @Autowired
    CalculationService calculationService;

    @Test
    void CalculationServiceTest_17() {
        ResponseValueDTO correctResponseValueDTO = new ResponseValueDTO(17, false, true);
        assertThat(correctResponseValueDTO, is(calculationService.calculateResult(new RequestValueDTO(17))));
    }

    @Test
    void CalculationServiceTest_24() {
        ResponseValueDTO correctResponseValueDTO = new ResponseValueDTO(24, true, false);
        assertThat(correctResponseValueDTO, is(calculationService.calculateResult(new RequestValueDTO(24))));
    }

}
