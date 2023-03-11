package com.bsuir.calculator;

import com.bsuir.calculator.dto.RequestValueDTO;
import com.bsuir.calculator.dto.ResponseValueDTO;
import com.bsuir.calculator.services.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class CalculatorApplicationTests {

    @Autowired
    private CalculationService calculationService;

    @Test
    public void СalculationServiceTest_17() {
        ResponseValueDTO correctResponseValueDTO = new ResponseValueDTO(17, false, true);
        assertThat(correctResponseValueDTO, is(calculationService.calculateResult(new RequestValueDTO(17))));
    }

    @Test
    public void CalculationServiceTest_24() {
        ResponseValueDTO correctResponseValueDTO = new ResponseValueDTO(24, true, false);
        assertThat(correctResponseValueDTO, is(calculationService.calculateResult(new RequestValueDTO(24))));
    }

}
