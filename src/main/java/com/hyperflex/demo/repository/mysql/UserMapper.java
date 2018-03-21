package com.hyperflex.demo.repository.mysql;

import com.hyperflex.demo.model.UserDO;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chuntaojun
 */
@Mapper
@Component
public interface UserMapper {

    /**
     *
     * @param userDO
     */
    @Insert(value = "insert into User(user_name, user_nickName, user_pwd) values(#{user_name}, #{user_nickName}," +
            " #{user_pwd})")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "user_id")
    void insert(UserDO userDO);

    /**
     *
     * @param userDO
     * @return
     */
    @Update(value = "update User set user_name=#{user_name}, user_level=#{user_level}, user_nickName=#{user_nickName}," +
            " user_IconId=#{user_IconId} where user_id=#{user_id}")
    Long udate(UserDO userDO);

    /**
     *
     * @param user_id
     * @return
     */
    @Delete(value = "delete from User where user_id=#{user_id}")
    Long delete(@Param("user_id") Long user_id);

    /**
     *
     * @return
     */
    @Select(value = "select user_id, user_name from User")
    List<UserDO> selectAll();

    /**
     *
     * @param user_name
     * @return
     */
    @Select("select user_id, user_name from User where user_name=#{user_name}")
    UserDO selectById(@Param("user_name") String user_name);

}
