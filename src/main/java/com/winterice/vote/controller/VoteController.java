package com.winterice.vote.controller;

import com.alibaba.fastjson.JSONObject;
import com.winterice.vote.annotation.Auth;
import com.winterice.vote.mapper.UserMapper;
import com.winterice.vote.mapper.VoteMapper;
import com.winterice.vote.pojo.*;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author dqbryant
 * @create 2020/11/7 10:23
 */
@RestController
@RequestMapping("/vote/")
public class VoteController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    VoteMapper voteMapper;
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    @PostMapping("vote")
    @Auth
    public ResponseJson<String> vote(@RequestBody() VoteVo voteVo, HttpServletResponse response){
        Integer[] ids = voteVo.voteList;
        String uid = response.getHeader("userId");
        User user = userMapper.selectById(uid);
        if(user.getHasVoteed() == 1){
            return new ResponseJson(ResultCode.UNVALIDPARAMS);
        }else {
            for (Integer groupId:ids){
                Vote vote = new Vote(uid, groupId);
                voteMapper.insert(vote);
            }
            return new ResponseJson<>(ResultCode.SUCCESS);
        }
    }
    @GetMapping("getVoteList")
    @Auth("admin")
    public ResponseJson<String> getVoteList(){
        List<Vote> list = voteMapper.getAll();
        return new ResponseJson<>(ResultCode.SUCCESS, JSONObject.toJSONString(list));
    }
    @GetMapping("getVote")
    @Auth()
    public ResponseJson<String> getVote(){
        return new ResponseJson<String>(ResultCode.SUCCESS,JSONObject.toJSONString(new GroupVo(voteMapper.getCount())));
    }
    @Update("reset")
    @Auth("admin")
    public ResponseJson<String> reset(){
        if(userMapper.reset()){
            return new ResponseJson<>(ResultCode.SUCCESS);
        }else {
            return new ResponseJson<>(ResultCode.UNVALIDPARAMS);
        }
    }
}
