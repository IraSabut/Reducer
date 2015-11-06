package com.instinctools.test.serviceImpl;

import com.instinctools.test.app.repository.dao.UserDao;
import com.instinctools.test.app.repository.entity.UserEntity;
import com.instinctools.test.domain.model.UserPrincipal;
import com.instinctools.test.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userRepository;


    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities;
    }


    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.updateUser(user);
    }

    @Override
    public UserEntity loadUserByCredentials(String login, String password) {
        UserEntity user = userRepository.findByCredentials(login, password);
        return user;
    }

    @Override
    public UserEntity getUserByID(Long userId) {
        UserEntity contractEntity = userRepository.findById(userId);
        return contractEntity;
    }

    @Override
    public UserPrincipal getUserByName(String username) {
        UserEntity user = userRepository.findByName(username);
        return null;
    }


    @Override
    public UserEntity loadUserByName(String userName) {
        UserEntity userEntity = userRepository.findByName(userName);
        return userEntity;
    }


}
