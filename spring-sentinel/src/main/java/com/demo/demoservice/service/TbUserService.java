package com.demo.demoservice.service;


import com.demo.repository.model.TbUser;

import java.util.List;

public interface TbUserService {
    String forTest() throws Exception;

    List<TbUser> getAllUsers();
}