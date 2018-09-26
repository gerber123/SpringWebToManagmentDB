package com.gerber.springdemo.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;

public class VipCodeConstarintValidator implements ConstraintValidator<VipCode,String>
{
    public String vipPrefix;

    public void initialize(VipCode vipCode) {
        vipPrefix = vipCode.value();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(s!=null&&s.length()>5)
        {
            result=s.startsWith(vipPrefix);
        }
        else
        {
            result=false;
        }
        return result;
    }
}
