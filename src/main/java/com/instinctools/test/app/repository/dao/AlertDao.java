package com.instinctools.test.app.repository.dao;

import com.instinctools.test.app.repository.base.GenericDao;
import com.instinctools.test.app.repository.entity.AlertEntity;

import java.util.List;

public interface AlertDao  extends GenericDao<AlertEntity, Long> {

    List<AlertEntity> findByTag(Long tagName) ;
    AlertEntity findByName(String alertName);
    List<AlertEntity> findByTagName(String tagName);
    List<AlertEntity> findByUserName(String userName);
}
