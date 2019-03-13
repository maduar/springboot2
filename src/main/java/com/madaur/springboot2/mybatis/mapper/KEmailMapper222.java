package com.madaur.springboot2.mybatis.mapper;


import com.madaur.springboot2.mybatis.model.KEmail;
import com.madaur.springboot2.mybatis.provider.KEmailProvider;
import com.madaur.springboot2.utils.SimpleSelectInExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KEmailMapper222 {

    int deleteByPrimaryKey(Integer kId);

    int insert(KEmail record);

    int insertSelective(KEmail record);

    KEmail selectByPrimaryKey(Integer kId);

    int updateByPrimaryKeySelective(KEmail record);

    int updateByPrimaryKey(KEmail record);

    @Select(" SELECT * FROM k_email ")
    List<KEmail> listKmail();

    @Insert(" insert into k_email(k_id, k_email, t_id) values(#{id}, #{email}, #{tId})  ")
    @SelectKey(statement = " SELECT max(k_id) from k_email  ",
            keyProperty = "id",
            resultType = Integer.class,
            before = false
    )
    int insert(@Param("id") Integer id,
               @Param("email") String email,
               @Param("tId") Integer tId);

    @Results(id = "userResult", value = {
            @Result(property = "kId", column = "k_id", id = true),
            @Result(property = "kEmail", column = "k_email"),
            @Result(property = "tId", column = "t_id")
    })
    @Select(" SELECT k_id, k_email, t_id FROM k_email WHERE k_email = #{email} AND t_id = #{tId} ")
    List<KEmail> listKmailByEmailAndTid(@Param("email") String email,
                                        @Param("tId") Integer tId);


    @SelectProvider(type = KEmailProvider.class, method = "listByEmail")
    List<KEmail> listByEmail(@Param("email") String email);

    @Lang(SimpleSelectInExtendedLanguageDriver.class)
    @SelectProvider(type = KEmailProvider.class, method = "listByEmailList")
    List<KEmail> listByEmailList(@Param("emailList") List<String> emailList);

}
