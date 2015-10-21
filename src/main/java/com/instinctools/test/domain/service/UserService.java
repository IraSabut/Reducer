package com.instinctools.test.domain.service;

import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.domain.model.UserPrincipal;

import java.util.List;

public interface UserService {

   // UserPrincipal loadUserByCredentials(String login, String password);

  //  UserPrincipal getUserByID(Long userId);
    UserEntity getUserByID(Long userId);

    UserPrincipal getUserByName(String username);
    List<UserEntity> getUsers();
   // UserEntity getUserByID(Long userId);

   UserEntity loadUserByCredentials(String login, String password);
UserEntity loadUserByName(String userName);
void save(UserEntity user);
    void updateUser(UserEntity user);


}
