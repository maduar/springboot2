package com.madaur.springboot2.druid;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;

/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 21/03/2019
 */
public class DruidConnectionProvider extends DruidDataSource {
    private static final long serialVersionUID = 1377390212442554779L;
    private static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMjtCkshfiEVjFYClpGYWlPK2ivYwbrNVx6QdUo/dN/6VBg8AeHwcVAZ6YjGNqE4kZPuqd3MZZpJ/9P6hbSxQn0CAwEAAQ==";

    @Override
    public void setUsername(String username) {
        try {
            this.username = ConfigTools.decrypt(publicKey, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setUsername(this.username);
    }
}
