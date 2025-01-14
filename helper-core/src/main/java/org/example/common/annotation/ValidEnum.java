package org.example.common.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.common.util.EnumValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = EnumValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnum {
    String message() default "Enum 클래스에 존재하지 않는 값입니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends java.lang.Enum<?>> enumClass();

}
