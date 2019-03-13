package com.madaur.springboot2.druid;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * description:
 * @author maduar
 * @date 17/12/2018 3:49 PM
 * @email maduar@163.com
 *
 * */
@Configuration
@Slf4j
public class DataSourceConfig {

  @Value("${spring.datasource.druid.test.url:error}")
  private String tenantUrl;

  @Primary
  @Bean(name = "testDataSource")
  @ConfigurationProperties("spring.datasource.druid.test")
  public DataSource tenantDataSource() {
    log.info("tenantUrl: " + tenantUrl);
    return new DruidDataSource();
  }

}
