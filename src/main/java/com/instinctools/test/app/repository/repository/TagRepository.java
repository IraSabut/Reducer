package com.instinctools.test.app.repository.repository;

import com.instinctools.test.app.repository.dao.TagDao;
import com.instinctools.test.app.repository.entity.TagEntity;
import com.instinctools.test.app.repository.hibernate.AbstractHibernateDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepository  extends AbstractHibernateDao<TagEntity, Long> implements TagDao {
    @Override
    public TagEntity findById(Long id) {
        Criteria cr = getSession().createCriteria(TagEntity.class, "TagEntity")
                .add(Restrictions.eq("id_tag", "id_tag"));
        return (TagEntity) cr.uniqueResult();
    }


    @Override
    public TagEntity findByName(String tagName) {
        Criteria cr = getSession()
                .createCriteria(TagEntity.class, "tag")
                .add(Restrictions.like("tagName", tagName));
        return (TagEntity) cr.uniqueResult();
    }
}
