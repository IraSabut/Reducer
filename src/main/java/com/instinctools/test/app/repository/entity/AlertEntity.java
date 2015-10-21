package com.instinctools.test.app.repository.entity;


import javax.persistence.*;

@Entity
@Table(name="ALERT")
public class AlertEntity {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ALERT ")
    private Long id;
    @Column(name="ALERT ")
    private String alertName;
    @Column(name="SHORT_ALERT")
    private String alertShortName;
    @Column(name="DESCRIPTION ")
    private String description;
    @Column(name="VIEWS")
    private int views;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    @JoinColumn(name="ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne
    private UserEntity userEntity;

    public TagEntity getTagEntity() {
        return tagEntity;
    }

    public void setTagEntity(TagEntity tagEntity) {
        this.tagEntity = tagEntity;
    }

    @JoinColumn(name="ID_TAG", referencedColumnName = "ID_TAG")
    @ManyToOne(optional = false)
    private TagEntity tagEntity;

    public AlertEntity() {

    }
    public AlertEntity(String alertName,String alertShortName, String description, TagEntity tagEntity, UserEntity userEntity) {
        this.alertName=alertName;
         this.alertShortName = this.alertShortName;
        this.description = description;
        this.views =0;
        this.userEntity=userEntity;
        this.tagEntity=tagEntity;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    public String getAlertShortName() {
       return "http://localhost:8084/"+String.valueOf(id);
     }

    public void setAlertShortName(String alertShortName) {
        String s=alertShortName.replaceAll("http://localhost:8084/","");
        this.alertShortName = s;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
