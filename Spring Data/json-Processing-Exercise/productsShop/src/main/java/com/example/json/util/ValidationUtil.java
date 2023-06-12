package com.example.json.util;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {

    <E> boolean isValid(E entity);
}
