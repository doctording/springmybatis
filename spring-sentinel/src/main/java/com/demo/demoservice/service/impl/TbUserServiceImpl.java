package com.demo.demoservice.service.impl;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.repository.mapper.TbUserMapper;
import com.demo.repository.model.TbUser;
import com.demo.repository.model.TbUserExample;
import com.demo.demoservice.limit.QueryLimit;
import com.demo.demoservice.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author mubi
 * @Date 2019/4/30 9:52 AM
 */
@Service
@Slf4j
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public String forTest() throws Exception{
        QueryLimit.initFlowRules();
        Entry entry = null;
        try {
            entry = SphU.entry(QueryLimit.RESOURCE_KEY);
            // 被保护的逻辑
            return "HelloWorld";
        } catch (BlockException ex) {
            // 处理被流控的逻辑
//            return "Blocked";
            throw new Exception("sentinel blocked");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    @Override
    public List<TbUser> getAllUsers() {
        List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
        return userList;
    }
}
