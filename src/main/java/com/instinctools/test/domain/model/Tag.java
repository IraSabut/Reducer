package com.instinctools.test.domain.model;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
public class Tag {
    private Long id;

    @NotBlank
    @Size(min=3, max=16)
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
