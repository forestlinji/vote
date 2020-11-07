package com.winterice.vote.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegisterVo {
    @NotNull
    private String stuId;
    @NotNull
    private String name;
    @NotNull
    @Range(min = 1, max = 11)
    private Integer group;
    @NotNull
    private String password;

    public RegisterVo() {
    }

    public RegisterVo(@NotNull String stuId, @NotNull String name, @NotNull Integer group, @NotNull String password) {
        this.stuId = stuId;
        this.name = name;
        this.group = group;
        this.password = password;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
