package com.project.message.messagerealtime.anotation.validator;

import com.project.message.messagerealtime.anotation.PhoneNumberValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.java.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValid, String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {

        String regex = "^(03|04|07|08|09)\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }

    @Override
    public void initialize(PhoneNumberValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
