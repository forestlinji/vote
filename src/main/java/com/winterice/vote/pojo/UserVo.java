package com.winterice.vote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dqbryant
 * @create 2020/11/7 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String userId;
    private String name;
    private Integer groupId;
    private List<Integer> voteList;

    public UserVo(User user ,List<Integer> voteList) {
        this.userId = user.getUid();
        this.groupId = user.getGroupId();
        this.name = user.getRealName();
        this.voteList = voteList;
    }
}
