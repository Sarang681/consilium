package com.consilium.consiliumbackend.common.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.springframework.util.StringUtils;

import com.consilium.consiliumbackend.common.annotations.Password;

public class UserPasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.hasLength(s)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Password cannot be blank").addConstraintViolation();
            return false;
        }

        PasswordValidator validator = new PasswordValidator(
                new LengthRule(8, 16),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
                new WhitespaceRule()
        );

        PasswordData passwordData = new PasswordData(s);
        RuleResult result = validator.validate(passwordData);
        if (!result.isValid()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            validator.getMessages(result).forEach(message -> constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation());
        }
        return result.isValid();
    }
}
