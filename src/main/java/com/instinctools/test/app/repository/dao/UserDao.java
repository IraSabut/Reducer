package com.instinctools.test.app.repository.dao;

import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.app.repository.base.GenericDao;


public interface UserDao extends GenericDao<UserEntity, Long> {

    void updateUser(UserEntity user);
    UserEntity findByCredentials(String login, String password);

    UserEntity findByName(String userName);
}
