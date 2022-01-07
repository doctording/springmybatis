package com.demo.control;

import com.demo.demoservice.service.TbUserService;
import com.demo.repository.model.TbUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TestLimitControl {

    @Autowired
    TbUserService tbUserService;

    @GetMapping(value = "/test")
    public String getTest() throws Exception {
        return "hello";
    }

    @GetMapping(value = "/test-limit")
    public String getTestService() throws Exception {
        return tbUserService.forTest();
    }

    /**
     * curl -X GET http://localhost:8080/test-all
     */
    @GetMapping(value = "/test-all")
    public List<TbUser> getTestAllUser() throws Exception {
        return tbUserService.getAllUsers();
    }

}
