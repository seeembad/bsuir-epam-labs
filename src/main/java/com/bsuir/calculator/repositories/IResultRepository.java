package com.bsuir.calculator.repositories;

import com.bsuir.calculator.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResultRepository extends JpaRepository<Result, Integer> {
}
