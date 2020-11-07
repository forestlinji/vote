package com.winterice.vote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class User {

    private String uid;
    private String realName;
    private String password;
    private Integer groupId;
    private Integer hasVoteed;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getHasVoteed() {
        return hasVoteed;
    }

    public void setHasVoteed(Integer hasVoteed) {
        this.hasVoteed = hasVoteed;
    }

    public User() {
    }

    public User(String uid, String realName, String password, Integer groupId, Integer hasVoteed) {
        this.uid = uid;
        this.realName = realName;
        this.password = password;
        this.groupId = groupId;
        this.hasVoteed = hasVoteed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(realName, user.realName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(groupId, user.groupId) &&
                Objects.equals(hasVoteed, user.hasVoteed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, realName, password, groupId, hasVoteed);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", groupId=" + groupId +
                ", hasVoteed=" + hasVoteed +
                '}';
    }
}
