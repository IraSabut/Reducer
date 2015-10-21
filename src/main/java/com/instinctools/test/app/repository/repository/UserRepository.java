package com.instinctools.test.app.repository.repository;

import com.instinctools.test.app.repository.hibernate.AbstractHibernateDao;
import com.instinctools.test.app.repository.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.instinctools.test.app.repository.dao.UserDao;

import java.util.List;

@Repository
public class UserRepository  extends AbstractHibernateDao<UserEntity, Long> implements UserDao {
    @Override
    public UserEntity findById(Long id) {
        Criteria cr = getSession().createCriteria(UserEntity.class, "UserEntity")
                .add(Restrictions.eq("id", id));
        return (UserEntity) cr.uniqueResult();
    }



    @Override
    public void updateUser(UserEntity user) {

    }

    @Override
    public UserEntity findByCredentials(String login, String password) {
        Criteria cr = getSession()
                .createCriteria(UserEntity.class, "users")
                .add(Restrictions.eq("username", login))
                .add(Restrictions.eq("password", password));
        return (UserEntity) cr.uniqueResult();
    }


    @Override
    public UserEntity findByName(String userName) {
        Criteria cr = getSession()
                .createCriteria(UserEntity.class, "users")
                .add(Restrictions.like("username", userName));
        return (UserEntity) cr.uniqueResult();
    }
}
