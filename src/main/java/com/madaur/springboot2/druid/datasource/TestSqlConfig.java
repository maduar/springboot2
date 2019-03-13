package com.madaur.springboot2.druid.datasource;

import com.madaur.springboot2.mybatis.model.KEmail;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
 
@EnableTransactionManagement
@MapperScan(basePackages = "com.maduar.springboot2.mybatis.dao", sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestSqlConfig {

	final String MAPPER_PATH = "classpath:mapper/KEmailMapper.xml";

	@Resource
	@Qualifier("testDataSource")
	private DataSource testDataSource;

	@Bean(name = "testTransactionManager")
	 public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource testDataSource) {
        return new DataSourceTransactionManager(testDataSource);
    }



	@Bean(name = "testSqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource testDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        Class[] classes = {KEmail.class};

        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_PATH));
        sessionFactory.setDataSource(testDataSource);
        sessionFactory.setTypeAliases(classes);
        return sessionFactory.getObject();
    }

}
