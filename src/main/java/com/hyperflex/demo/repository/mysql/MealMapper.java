package com.hyperflex.demo.repository.mysql;

import com.hyperflex.demo.model.MealDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

/**
 * @author chuntaojun
 */
@Mapper
@Component
public interface MealMapper {

    /**
     *
     * @param mealDO
     */
    @Insert(value = "insert into Meal(user_id, food_code, meal_type, eat_time, season_code) values (#{user_id}, " +
            "#{food_code}, #{meal_type}, #{eat_time}, #{season_code})")
    @Options(useGeneratedKeys = true, keyColumn = "meal_id", keyProperty = "meal_id")
    void insert(MealDO mealDO);

}
