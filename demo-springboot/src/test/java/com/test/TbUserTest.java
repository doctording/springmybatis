package com.test;

import com.example.demo.DemoApplication;
import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TbUserTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testGetAllUsers(){
        List<TbUser> userList = tbUserService.getAllUser();
        System.out.println("==============");
        userList.forEach(tbUser -> {
            System.out.println(tbUser);
        });
        System.out.println("==============");
    }

    @Test
    public void testGetUserById(){
        Integer id= 1;
        TbUser user = tbUserService.getById(id);
        System.out.println(user);
    }
}
