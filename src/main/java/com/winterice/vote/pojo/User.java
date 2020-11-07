package com.winterice.vote.pojo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Objects;


public class User {
    @TableId
    private String uid;
    private String realName;
    private String password;
    private Integer groupId;
    private Integer hasVoted;

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

    public Integer getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Integer hasVoted) {
        this.hasVoted = hasVoted;
    }

    public User() {
    }

    public User(String uid, String realName, String password, Integer groupId, Integer hasVoted) {
        this.uid = uid;
        this.realName = realName;
        this.password = password;
        this.groupId = groupId;
        this.hasVoted = hasVoted;
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
                Objects.equals(hasVoted, user.hasVoted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, realName, password, groupId, hasVoted);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", groupId=" + groupId +
                ", hasVoteed=" + hasVoted +
                '}';
    }
}
