package com.example.demo.redis.service;


import com.example.demo.redis.repository.model.TbUser;

import java.util.List;

public interface TbUserService {
    String fortest();

    List<TbUser> getAllUser();

    TbUser getById(Integer id);

    String getNameById(Integer id);

    String getNameCacheById(Integer id);

}