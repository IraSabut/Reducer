package com.instinctools.test.domain.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Alert {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 16)
    private String alert;
    @NotBlank
    @Size(min = 3, max = 16)
    private String shortAlert;
    @NotBlank
    @Size(min = 3, max = 160)
    private String description;
    @NotBlank
    private String views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getShortAlert() {
        return shortAlert;
    }

    public void setShortAlert(String shortAlert) {
        this.shortAlert = shortAlert;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}
