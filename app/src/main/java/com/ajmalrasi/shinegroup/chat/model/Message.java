package com.ajmalrasi.shinegroup.chat.model;

import java.io.Serializable;

/**
 * Created by Rasi on 06-02-2018.
 */

public class Message implements Serializable {
    String id, message, createdAt;

    Member member;

    public Message() {
    }

    public Message(String id, String message, String createdAt, Member member) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
        this.member = member;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
