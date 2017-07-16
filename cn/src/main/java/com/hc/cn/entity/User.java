package com.hc.cn.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String loginName;
    private String loginPassword;
    private String firstName;
    private String lastName;

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
}