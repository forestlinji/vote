package com.winterice.vote;


import cn.hutool.core.lang.Assert;
import com.winterice.vote.utils.MD5Utils;
import com.winterice.vote.vo.LoginVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class testUserController {
    public String baseUrl = "http://localhost:11451";
    @Test
    public void testCptry(){
        String cptry = MD5Utils.cptry("123456");
        System.out.println(cptry);
    }

    @Test
    public void testLogin(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(baseUrl + "/user/login", new LoginVo("0", "123456"), Object.class);
        Assert.isTrue(objectResponseEntity.getStatusCodeValue() == 200);
    }
}
