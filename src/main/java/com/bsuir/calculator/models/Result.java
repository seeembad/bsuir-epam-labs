package com.bsuir.calculator.models;

import com.bsuir.calculator.dto.ResponseValueDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "calculations", schema = "public")
public class Result {
    @Id
    @Column(name = "value")
    private int value;

    @Column(name = "iseven")
    private boolean isEven;

    @Column(name = "isprime")
    private boolean isPrime;

    public Result(ResponseValueDTO responseValueDTO) {
        this.value = responseValueDTO.getValue();
        this.isEven = responseValueDTO.isEven();
        this.isPrime = responseValueDTO.isPrime();
    }
}
