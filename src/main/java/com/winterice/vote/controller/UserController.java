package com.winterice.vote.controller;

import com.winterice.vote.annotation.Auth;
import com.winterice.vote.interceptor.LoginInterceptor;
import com.winterice.vote.mapper.RoleMapper;
import com.winterice.vote.mapper.UserMapper;
import com.winterice.vote.pojo.ResponseJson;
import com.winterice.vote.pojo.ResultCode;
import com.winterice.vote.pojo.User;
import com.winterice.vote.service.RoleService;
import com.winterice.vote.service.UserService;
import com.winterice.vote.utils.JwtTokenUtils;
import com.winterice.vote.utils.MD5Utils;
import com.winterice.vote.vo.LoginVo;
import com.winterice.vote.vo.RegisterVo;
import com.winterice.vote.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    ThreadLocal<String> userLocal = new ThreadLocal<>();
    @Autowired
    public UserService userService;
    @Autowired
    public RoleService roleService;
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public RoleMapper roleMapper;

    /**
     * 用户登录
     * @author forestj
     */
    @PostMapping("login")
    public ResponseJson login(@RequestBody LoginVo loginVo, HttpServletResponse response){
        String username = loginVo.getUsername();
        User user = userService.findUserById(username);
        if(user == null){
            return new ResponseJson(ResultCode.UNVALIDPARAMS);
        }
        loginVo.setPassword(MD5Utils.cptry(loginVo.getPassword()));
        if(!loginVo.getPassword().equals(user.getPassword())){
            return new ResponseJson(ResultCode.UNVALIDPARAMS);
        }
        List<String> roleListById = roleService.getRoleListById(username);
        String token = JwtTokenUtils.createToken(username, roleListById, true);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Authorization", token);
        return new ResponseJson(ResultCode.SUCCESS);
    }

    /**
     * 用户注册
     * @author forestj
     */
    @PostMapping("register")
    public ResponseJson register(@RequestBody @Valid RegisterVo registerVo){
        String stuId = registerVo.getStuId();
        if (userService.findUserById(stuId) != null) {
            return new ResponseJson(ResultCode.UNVALIDPARAMS);
        }
        User user = new User();
        user.setUid(stuId);
        user.setRealName(registerVo.getName());
        user.setPassword(MD5Utils.cptry(registerVo.getPassword()));
        user.setHasVoted(0);
        user.setGroupId(registerVo.getGroup());
        userMapper.insert(user);
        userMapper.addRole(user.getUid());
        return new ResponseJson(ResultCode.SUCCESS);
    }

    @GetMapping("getUserInfo")
    @Auth
    public ResponseJson<UserInfo> getUserInfo(){
//        String userId = response.getHeader("userId");
        String userId = LoginInterceptor.getUserId();
        User user = userMapper.selectById(userId);
        if (user == null) {
            return new ResponseJson(ResultCode.UNVALIDPARAMS);
        }
        List<String> roleListById = roleMapper.getRoleListById(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setRole(roleListById);
        userInfo.setHasVoted(user.getHasVoted());
        userInfo.setName(user.getRealName());
        userInfo.setGroupId(user.getGroupId());
        return new ResponseJson<>(ResultCode.SUCCESS, userInfo);
    }

}
