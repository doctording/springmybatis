package com.example.demo.service.impl;

import com.example.demo.repository.mapper.TbUserMapper;
import com.example.demo.repository.model.TbUser;
import com.example.demo.repository.model.TbUserExample;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService{

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public String fortest(){
        return "For Test";
    }

    @Override
    public List<TbUser> getAllUser() {
        List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
        return userList;
    }

    @Override
    public TbUser getById(Integer id) {
        System.out.println("get by id:" + id + " " + System.currentTimeMillis());
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getNameById(Integer id) {
        TbUser tbUser =  tbUserMapper.selectByPrimaryKey(id);
        if(tbUser != null){
            return tbUser.getName();
        }
        return null;
    }

}
