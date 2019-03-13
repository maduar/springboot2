package com.madaur.springboot2.service.impl;

import com.madaur.springboot2.service.KEmailService;
import com.madaur.springboot2.mybatis.model.KEmail;
import com.madaur.springboot2.mybatis.dao.KEmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 07/03/2019
 */
@Service
public class KEmailServiceImpl implements KEmailService {

    @Autowired
    private KEmailMapper kEmailMapper;

    @Override
    public List<KEmail> getAllKmail() {
        return null;
//        return kEmailMapper.listKmail();
    }

    @Override
    public int insert(Integer id, String email, Integer tId) {
        return 0;
//        return kEmailMapper.insert(id, email, tId);
    }
}
