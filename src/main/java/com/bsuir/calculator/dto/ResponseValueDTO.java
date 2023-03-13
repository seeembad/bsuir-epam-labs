package com.bsuir.calculator.dto;

import com.bsuir.calculator.models.Result;

public class ResponseValueDTO {
    private int value;
    private boolean isPrime;
    private boolean isEven;
    public ResponseValueDTO(Result referenceById) {
        this.value = referenceById.getValue();
        this.isEven = referenceById.isEven();
        this.isPrime = referenceById.isPrime();
    }

    public ResponseValueDTO(int value, boolean isPrime, boolean isEven) {
        this.value = value;
        this.isPrime = isPrime;
        this.isEven = isEven;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }
}
