package com.bsuir.calculator;

import com.bsuir.calculator.DTO.RequestValueDTO;
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
    void CalculationServiceTest() {
        HashMap<String, Boolean> correctHashMap = new HashMap<>();
        correctHashMap.put("even", false);
        correctHashMap.put("prime", true);
        HashMap<String, Boolean> hashMap = calculationService.calculateResult(new RequestValueDTO(17));

        assertThat(correctHashMap, is(hashMap));
    }

}
