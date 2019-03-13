package com.madaur.springboot2.service;

import com.madaur.springboot2.mybatis.model.KEmail;

import java.util.List;

/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 07/03/2019
 */
public interface KEmailService {
    List<KEmail> getAllKmail();

    int insert(Integer id, String email, Integer tId);
}
