package com.bsuir.calculator.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public class RequestValueDTO {

    @NotNull
    @Digits(integer = 7, fraction = 0, message = "max 7nums in integer")
    private int value;

    public RequestValueDTO() {
    }

    public RequestValueDTO(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
