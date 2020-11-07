package com.winterice.vote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dqbryant
 * @create 2020/11/7 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCount {
    private Integer groupId;
    private Integer count;
}
