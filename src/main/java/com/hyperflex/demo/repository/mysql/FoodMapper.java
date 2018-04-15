package com.hyperflex.demo.repository.mysql;

import com.hyperflex.demo.model.FoodDO;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chuntaojun
 */
@Mapper
@Component
public interface FoodMapper {

    /**
     *
     * @param foodDO
     */
    @Insert(value = "insert into Food(food_code, food_name) values (#{food_code}, #{food_name})")
    @Options(useGeneratedKeys = false, keyColumn = "food_code", keyProperty = "food_code")
    void insert(FoodDO foodDO);

    /**
     *
     * @param foodDO
     * @return
     */
    @Update(value = "update Food set food_code=#{food_code}, food_name=#{food_code}")
    Long update(FoodDO foodDO);

    /**
     *
     * @param food_code
     * @return
     */
    @Delete(value = "delete from Food where food_code=#{food_code}")
    Long delete(@Param("food_code") Long food_code);

    /**
     *
     * @return
     */
    @Select(value = "select food_code, food_name from Food")
    List<FoodDO> selectAll();

    /**
     *
     * @param food_code
     * @return
     */
    @Select(value = "select food_code, food_name form Food where food_code=#{food_code}")
    FoodDO select(@Param("food_code") Long food_code);

}
