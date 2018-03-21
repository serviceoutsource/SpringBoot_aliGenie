package com.hyperflex.demo.model;

/**
 * @author chuntaojun
 */
public class FoodDO {

    private Long food_code;
    private String food_name;

    public Long getFood_code() {
        return food_code;
    }

    public void setFood_code(Long food_code) {
        this.food_code = food_code;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    @Override
    public String toString() {
        return "FoodDO{" +
                "food_code=" + food_code +
                ", food_name='" + food_name + '\'' +
                '}';
    }
}
