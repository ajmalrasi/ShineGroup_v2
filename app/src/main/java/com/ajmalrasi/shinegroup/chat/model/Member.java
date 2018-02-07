package com.ajmalrasi.shinegroup.chat.model;

import java.io.Serializable;

/**
 * Created by Rasi on 06-02-2018.
 */

public class Member implements Serializable {

    String id, name, email,dp,created;

    public Member() {
    }

    public Member(String id, String name, String email,String created, String dp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created = created;
        this.dp = dp;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
