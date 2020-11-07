package com.winterice.vote.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dqbryant
 * @create 2020/11/7 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteVo {
    public int[] voted;
}
