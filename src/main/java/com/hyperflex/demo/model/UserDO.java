package com.hyperflex.demo.model;


/**
 * @author chuntaojun
 */
public class UserDO {

    private Long user_id;
    private String user_name;
    private Integer user_level;
    private String user_nickName;
    private String user_IconId;
    private String user_pwd;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_level() {
        return user_level;
    }

    public void setUser_level(Integer user_level) {
        this.user_level = user_level;
    }

    public String getUser_nickName() {
        return user_nickName;
    }

    public void setUser_nickName(String user_nickName) {
        this.user_nickName = user_nickName;
    }

    public String getUser_IconId() {
        return user_IconId;
    }

    public void setUser_IconId(String user_IconId) {
        this.user_IconId = user_IconId;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_level=" + user_level +
                ", user_nickName='" + user_nickName + '\'' +
                ", user_IconId='" + user_IconId + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
