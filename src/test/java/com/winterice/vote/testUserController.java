package com.winterice.vote;


import com.winterice.vote.utils.MD5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testUserController {
    @Test
    public void test01(){
        String cptry = MD5Utils.cptry("123456");
        System.out.println(cptry);
    }
}
