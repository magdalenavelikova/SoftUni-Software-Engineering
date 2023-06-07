package bg.softuni.gamestore.util;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {
    <E> Set<ConstraintViolation<E>> violation(E entity);
    <E> boolean isValid(E entity);
}
