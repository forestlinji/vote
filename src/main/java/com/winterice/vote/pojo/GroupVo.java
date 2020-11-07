package com.winterice.vote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dqbryant
 * @create 2020/11/7 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupVo {
    private List<Group> records;
}
