package com.madaur.springboot2.mybatis.dao;


import com.madaur.springboot2.mybatis.model.KEmail;
import com.madaur.springboot2.mybatis.provider.KEmailProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface KEmailMapper {

    int deleteByPrimaryKey(Integer kId);

    int insert(KEmail record);

    int insertSelective(KEmail record);

    KEmail selectByPrimaryKey(Integer kId);

    KEmail selectByKid(Integer kId);

    List<KEmail> selectByMailAndTId(@Param("kEmail") String kEmail, @Param("tId") Integer tId);

    int updateByPrimaryKeySelective(KEmail record);

    int updateByPrimaryKey(KEmail record);


    List<KEmail> listByEmail(@Param("emailList") List<String> emailList);

}
