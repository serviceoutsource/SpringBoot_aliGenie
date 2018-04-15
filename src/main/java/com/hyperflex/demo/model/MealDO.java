package com.hyperflex.demo.model;

import java.util.Date;

/**
 * @author chuntaojun
 */
public class MealDO {

    private Long meal_id;
    private Long user_id;
    private Long food_code;
    private Integer meal_type;
    private Date eat_time;
    private Integer season_code;

    public Long getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(Long meal_id) {
        this.meal_id = meal_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getFood_code() {
        return food_code;
    }

    public void setFood_code(Long food_code) {
        this.food_code = food_code;
    }

    public Integer getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(Integer meal_type) {
        this.meal_type = meal_type;
    }

    public Date getEat_time() {
        return eat_time;
    }

    public void setEat_time(Date eat_time) {
        this.eat_time = eat_time;
    }

    public Integer getSeason_code() {
        return season_code;
    }

    public void setSeason_code(Integer season_code) {
        this.season_code = season_code;
    }

    @Override
    public String toString() {
        return "MealDO{" +
                "meal_id=" + meal_id +
                ", user_id=" + user_id +
                ", food_code=" + food_code +
                ", meal_type=" + meal_type +
                ", eat_time=" + eat_time +
                ", season_code=" + season_code +
                '}';
    }
}
