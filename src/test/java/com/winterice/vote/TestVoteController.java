package com.winterice.vote;

import cn.hutool.core.lang.Assert;
import cn.hutool.http.Method;
import com.winterice.vote.pojo.VoteVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
public class TestVoteController {
    String baseUrl = "http://localhost:11451";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJST0xFIjoidXNlcixhZG1pbiIsImlzcyI6IkZvcmVzdGpDbGltYiIsImlhdCI6MTYwNDc1NzY5NSwic3ViIjoiMCIsImV4cCI6MTYwNzM0OTY5NX0.0-dnGR66F4gQSf50zkxfS3dInWNbFmBCo9bGlWfjhwI";
    @Test
    public void testVote(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity<Object>(new VoteVo(new int[]{1, 2, 3}),requestHeaders);
        ResponseEntity<Object> responseEntity =  restTemplate.postForEntity(baseUrl + "/vote/vote", httpEntity, Object.class);
        Assert.isTrue(responseEntity.getStatusCodeValue() == 200);
    }
    @Test
    public void testGetVoteList(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity<Object>(null,requestHeaders);
        ResponseEntity<Object> responseEntity =  restTemplate.exchange(baseUrl + "/vote/getVoteList?pageNum=2", HttpMethod.GET, httpEntity, Object.class);
        Assert.isTrue(responseEntity.getStatusCodeValue() == 200);
    }
    /**
     * 测试获取投票信息
     * @author ganjy
     */
    @Test
    public void testGetVote(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity<Object>(null,requestHeaders);
        ResponseEntity<Object> responseEntity =  restTemplate.exchange(baseUrl + "/vote/getVote", HttpMethod.GET, httpEntity, Object.class);
        Assert.isTrue(responseEntity.getStatusCodeValue() == 200);
    }
    @Test
    public void testReset(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", token);
        HttpEntity httpEntity = new HttpEntity<Object>(null,requestHeaders);
        ResponseEntity<Object> responseEntity =  restTemplate.exchange(baseUrl + "/vote/reset", HttpMethod.GET, httpEntity, Object.class);
        Assert.isTrue(responseEntity.getStatusCodeValue() == 200);
    }
}
