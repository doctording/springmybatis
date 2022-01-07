package com.example.demo.redis.control;

import com.example.demo.redis.repository.model.TbUser;
import com.example.demo.redis.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    @GetMapping(value = "/test")
    public String getTest() throws Exception {
        return "hello test";
    }

    @GetMapping(value = "/test-service")
    public String getTestService() throws Exception {
        return tbUserService.fortest();
    }

    @GetMapping(value = "/test-all")
    public List<TbUser> getTestAllUser() throws Exception {
        return tbUserService.getAllUser();
    }

    @GetMapping(value = "/user/get/{uid}")
    public TbUser getUserById(@PathVariable Integer uid) throws Exception {
        return tbUserService.getById(uid);
    }

    /**
     * curl -X GET http://localhost:8080/user/name/cache/1
     */
    @GetMapping(value = "/user/name/cache/{uid}")
    public String getUserCacheById(@PathVariable Integer uid) throws Exception {
        return tbUserService.getNameCacheById(uid);
    }

}
