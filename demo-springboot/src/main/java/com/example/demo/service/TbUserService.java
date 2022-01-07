package com.example.demo.service;


import com.example.demo.repository.model.TbUser;

import java.util.List;

public interface TbUserService {
    String fortest();

    List<TbUser> getAllUser();

    TbUser getById(Integer id);

    String getNameById(Integer id);

}