package com.hyperflex.demo.model;

import java.util.Set;

/**
 * @author chuntaojun
 */
public class LabelDO {

    private String user_id;
    private Set<String> taste_label;
    private Integer crowd_label;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTaste_label() {
        return taste_label.toString();
    }

    public void setTaste_label(String taste_label) {
        this.taste_label.add(taste_label);
    }

    public Integer getCrowd_label() {
        return crowd_label;
    }

    public void setCrowd_label(Integer crowd_label) {
        this.crowd_label = crowd_label;
    }

    @Override
    public String toString() {
        return "LabelDO{" +
                "user_id=" + user_id +
                ", taste_label='" + taste_label + '\'' +
                ", crowd_label=" + crowd_label +
                '}';
    }
}
