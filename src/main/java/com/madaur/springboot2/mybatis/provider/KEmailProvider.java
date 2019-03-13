package com.madaur.springboot2.mybatis.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;


/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 07/03/2019
 */
public class KEmailProvider {

    public String listByEmail(@Param("email") final String email) {
        return new SQL(){
            {
                SELECT(" k_id AS kId, k_email AS kEmail, t_id AS tId ");
                FROM(" k_email ");
                if (email != null && !"".equals(email.trim())) {
                    WHERE(" k_email = #{email}");
                }
            }
        }.toString();
    }


    public String listByEmailList(@Param("emailList")  List<String> emailList) {
        return new SQL(){
            {
                SELECT(" k_id AS kId, k_email AS kEmail, t_id AS tId ");
                FROM(" k_email ");
                if (emailList != null && emailList.size() != 0) {
                    WHERE(" k_email in ( #{emailList} ) ");
                }
            }
        }.toString();
    }
}
