package com.hyperflex.demo.repository.mysql;

import com.hyperflex.demo.model.LabelDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

/**
 * @author chuntaojun
 */
@Mapper
@Component
public interface LabelMapper {

    @Insert(value = "insert into Label(user_id, taste_label, crowd_label) values (#{user_id}, #{taste_label}, #{crowd_label})")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "user_id")
    void insert(LabelDO labelDO);

}
