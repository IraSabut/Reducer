package com.instinctools.test.domain.model;

public class UserPrincipal {

    private Long userId;

    private String name;

    private String login;

    private String password;


    public UserPrincipal() {
    }

    public UserPrincipal(Long userId, String name) {
        super();
        this.userId = userId;
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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


}
