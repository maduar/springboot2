package com.madaur.springboot2.druid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * description:
 *
 * @author maduar
 * @date 17/12/2018 3:49 PM
 * @email maduar@163.com
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "testDataSource")
    @ConfigurationProperties("spring.datasource.druid.test")
    public DataSource tenantDataSource() {
        return new DruidConnectionProvider();
    }

}
