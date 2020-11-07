package com.winterice.vote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winterice.vote.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select r.role_name from role r,user_role ur where r.role_id = ur.role_id and ur.uid=#{userId}")
    List<String> getRoleListById(String userId);
}
