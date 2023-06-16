package bg.softuni.productshop.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator =
                Validation.buildDefaultValidatorFactory().getValidator();
    }
    @Override
    public <E> boolean isValid(E entity) {
        Set<ConstraintViolation<E>> validate = validator.validate(entity);

        if (!validate.isEmpty()) {
            validate.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return true;
        }
        return validate.isEmpty();
    }
}
