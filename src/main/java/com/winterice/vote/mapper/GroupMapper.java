package com.winterice.vote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterice.vote.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dqbryant
 * @create 2020/11/7 16:17
 */
@Repository
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
    @Update("update groupss set num = num + 1 where group_id = #{0}")
    int addNum(int groupId);
    @Update("update groupss set num = 0")
    int reset();
    @Select("select * from groupss")
    List<Group> selectAll();
}
