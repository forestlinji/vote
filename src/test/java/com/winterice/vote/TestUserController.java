package com.winterice.vote;


import cn.hutool.core.lang.Assert;
import com.winterice.vote.utils.MD5Utils;
import com.winterice.vote.vo.LoginVo;
import com.winterice.vote.vo.RegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class TestUserController {
    public String baseUrl = "http://localhost:11451";
    public String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJST0xFIjoidXNlcixhZG1pbiIsImlzcyI6IkZvcmVzdGpDbGltYiIsImlhdCI6MTYwNDc1NzY5NSwic3ViIjoiMCIsImV4cCI6MTYwNzM0OTY5NX0.0-dnGR66F4gQSf50zkxfS3dInWNbFmBCo9bGlWfjhwI";
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
    /**
     * 测试获取用户信息
     * @author zhangtingyi20
     */
    @Test
    public void testGetUserInfo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity<Object>(null,requestHeaders);
        ResponseEntity<Object> response = restTemplate.exchange(baseUrl + "/user/getUserInfo", HttpMethod.GET, httpEntity, Object.class);
        Assert.isTrue(response.getStatusCodeValue() == 200);
    }

    @Test
    public void testRegister(){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity<Object>(new RegisterVo("031802220", "fff", 4, "123456"),null);
        ResponseEntity<Object> response = restTemplate.exchange(baseUrl + "/user/register", HttpMethod.POST, httpEntity, Object.class);
        Assert.isTrue(response.getStatusCodeValue() == 200);
    }
}
