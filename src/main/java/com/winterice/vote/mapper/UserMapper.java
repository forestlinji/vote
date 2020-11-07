package com.winterice.vote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterice.vote.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author dqbryant
 * @create 2020/11/7 10:35
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update user set has_voted = 1 where uid = #{0}")
    boolean vote(String uid);
    @Update("update user set has_voted = 0")
    boolean reset();

    @Insert("insert into user_role values(#{uid}, 1)")
    void addRole(String uid);
}
