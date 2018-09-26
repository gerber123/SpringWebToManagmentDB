package com.gerber.springdemo.Validation;





import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy=VipCodeConstarintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VipCode
{
    public String value() default "VIP";
    public String message() default "If you dont have premium code, go to normaly register";
    public Class<?>[] groups() default {} ;
    public Class<? extends Payload>[] payload() default{};

}
