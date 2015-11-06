package com.instinctools.test.serviceImpl;


import com.instinctools.test.app.repository.dao.TagDao;
import com.instinctools.test.app.repository.entity.TagEntity;
import com.instinctools.test.domain.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagRepository;

    @Override
    public List<TagEntity> getTags() {
        List<TagEntity> tagEntities = tagRepository.findAll();
        return tagEntities;
    }

    @Override
    public TagEntity getTagByID(Long tagId) {
        return null;
    }

    @Override
    public void save(TagEntity tag) {
        tagRepository.save(tag);
    }

    @Override
    public TagEntity getTagByName(String tagName) {
        TagEntity tag = tagRepository.findByName(tagName);
        return tag;
    }
}
