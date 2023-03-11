package com.bsuir.calculator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Result {
    @Id
    private int value;
    private boolean isEven;
    private boolean isPrime;

    public Result(int value, boolean isEven, boolean isPrime) {
        this.value = value;
        this.isEven = isEven;
        this.isPrime = isPrime;
    }
}
