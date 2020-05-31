package com.jl.graduatedesign.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_user")
public class User {
    @Column(name = "user_id")
    private Long userId;

    private Byte type;

    @Column(name = "user_name")
    private String userName;

    private String code;

    private String password;

    private Byte sex;

    private Date birthday;

    private String tel;

    private String email;

    private Long version;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", type=" + type +
                ", userName='" + userName + '\'' +
                ", code='" + code + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", version=" + version +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
