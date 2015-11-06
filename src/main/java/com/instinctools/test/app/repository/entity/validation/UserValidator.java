package com.instinctools.test.app.repository.entity.validation;

import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.domain.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User signupForm = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Username must not be empty.");
        String username = signupForm.getLogin();
        if ((username.length()) > 16) {
            errors.rejectValue("password", "username.tooLong", "Username must not more than 16 characters.");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");


    }


}
