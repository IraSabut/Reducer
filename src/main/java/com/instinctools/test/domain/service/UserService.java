package com.instinctools.test.domain.service;

import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.domain.model.UserPrincipal;

import java.util.List;

public interface UserService {


    UserEntity getUserByID(Long userId);

    UserPrincipal getUserByName(String username);

    List<UserEntity> getUsers();

    UserEntity loadUserByCredentials(String login, String password);

    UserEntity loadUserByName(String userName);

    void save(UserEntity user);

    void updateUser(UserEntity user);


}
