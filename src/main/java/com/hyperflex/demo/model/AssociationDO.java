package com.hyperflex.demo.model;

/**
 * @author chuntaojun
 */
public class AssociationDO {

    private Long id;
    private Long muser_id;
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMuser_id() {
        return muser_id;
    }

    public void setMuser_id(Long muser_id) {
        this.muser_id = muser_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", muser_id=" + muser_id +
                ", user_id=" + user_id +
                '}';
    }

}
