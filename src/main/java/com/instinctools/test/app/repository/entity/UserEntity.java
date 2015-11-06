package com.instinctools.test.app.repository.entity;


import com.instinctools.test.domain.model.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "ROLE_ID")
    private Role idRole;

    public Role getIdRole() {
        return idRole;

    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public UserEntity(String name, String password, Role idRole) {

        this.username = name;
        this.password = password;
        this.idRole = idRole;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + username + ", password=" + password
                + "]";
    }
}
