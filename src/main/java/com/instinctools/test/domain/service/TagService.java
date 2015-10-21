package com.instinctools.test.domain.service;

import com.instinctools.test.app.repository.entity.TagEntity;

import java.util.List;

public interface TagService {
    List<TagEntity> getTags();
    TagEntity getTagByID(Long tagId);
    void save(TagEntity tag);
    TagEntity getTagByName(String tagName);
}
