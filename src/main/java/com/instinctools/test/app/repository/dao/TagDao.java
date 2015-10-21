package com.instinctools.test.app.repository.dao;


import com.instinctools.test.app.repository.base.GenericDao;
import com.instinctools.test.app.repository.entity.TagEntity;

import java.util.List;

public interface TagDao  extends GenericDao<TagEntity, Long> {
    TagEntity findByName(String tagName);
}
