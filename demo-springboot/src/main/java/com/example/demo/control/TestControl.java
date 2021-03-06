package com.example.demo.control;

import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    @GetMapping(value = "/test")
    public String getTest() throws Exception {
        return "hello test";
    }

    @GetMapping(value = "/test/param")
    public String getTestParam(Integer id, String name) throws Exception {
        if (id > 0 && id < 128) {
            return id + "_" + name;
        }
        if (id > 1000 || id <= 0) {
            throw new Exception("id illegal");
        }
        return id + ":" + name;
    }

    @GetMapping(value = "/test-service")
    public String getTestService() throws Exception {
        return tbUserService.fortest();
    }

    @GetMapping(value = "/test-all")
    public List<TbUser> getTestAllUser() throws Exception {
        return tbUserService.getAllUser();
    }

    /**
     * curl -X GET http://localhost:8080/user/get/1
     */
    @GetMapping(value = "/user/get/{uid}")
    public TbUser getUserById(@PathVariable Integer uid) throws Exception {
        return tbUserService.getById(uid);
    }

}
