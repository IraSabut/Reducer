package com.instinctools.test.domain.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class User {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 16)
    private String login;
    @NotBlank
    @Size(min = 3, max = 16)
    private String password;
    private Role idRole;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
