package com.winterice.vote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterice.vote.pojo.GroupCount;
import com.winterice.vote.pojo.Vote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dqbryant
 * @create 2020/11/7 10:31
 */
public interface VoteMapper extends BaseMapper<Vote> {
    @Select("select * from vote")
    List<Vote> getAll();
    @Select("select count(*) count,group_id from vote group by group_id")
    List<GroupCount> getCount();
}
