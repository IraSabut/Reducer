package com.instinctools.test.app.repository.repository;

import com.instinctools.test.app.repository.dao.AlertDao;
import com.instinctools.test.app.repository.entity.AlertEntity;
import com.instinctools.test.app.repository.entity.TagEntity;
import com.instinctools.test.app.repository.hibernate.AbstractHibernateDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AlertRepository  extends AbstractHibernateDao<AlertEntity, Long> implements AlertDao {
    @Override
    public List<AlertEntity> findByTag(Long id) {
        Criteria cr = getSession()
                .createCriteria(AlertEntity.class, "alert")
             //   .add(Restrictions.like("tagEntity", "%"))
                .add(Restrictions.eq("tagEntity.id", id));
        //return (List)((AlertEntity) cr.list();
        return  cr.list();

    }
    @Override
    public AlertEntity findByName(String alertName) {
        Criteria cr = getSession()
                .createCriteria(TagEntity.class, "alert")
                .add(Restrictions.like("alertName", alertName));
        return (AlertEntity) cr.uniqueResult();
    }
    @Override
    public List<AlertEntity> findByTagName(String tagName) {
        Criteria cr = getSession()
                .createCriteria(AlertEntity.class, "alert");
        cr.createAlias("alert.tagEntity", "tag");
        cr.add(Restrictions.eq("tag.tagName", tagName));
        return (List<AlertEntity>) cr.list();
    }

    @Override
    public List<AlertEntity> findByUserName(String userName) {
        Criteria cr = getSession()
                .createCriteria(AlertEntity.class, "alert");
        cr.createAlias("alert.userEntity", "users");
        cr.add(Restrictions.eq("users.username", userName));
        return (List<AlertEntity>) cr.list();
    }

}
