package com.winterice.vote.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dqbryant
 * @create 2020/11/7 10:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @TableId
    private Integer groupId;
    private String link;
    private Integer num;
}
