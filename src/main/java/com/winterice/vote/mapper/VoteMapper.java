package com.winterice.vote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterice.vote.pojo.Vote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dqbryant
 * @create 2020/11/7 10:31
 */
@Repository
@Mapper
public interface VoteMapper extends BaseMapper<Vote> {
    @Select("select * from vote")
    List<Vote> getAll();
    @Select("select group_id from vote where uid = #{0}")
    List<Integer> getVoteList(String uid);
}
