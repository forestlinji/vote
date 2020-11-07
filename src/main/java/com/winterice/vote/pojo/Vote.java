package com.winterice.vote.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dqbryant
 * @create 2020/11/7 10:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @TableField("uid")
    private String userId;
    private Integer groupId;
}
