package com.madaur.springboot2.druid.datasource;

import com.madaur.springboot2.enums.SexEnum;
import com.madaur.springboot2.mybatis.model.KEmail;
import com.madaur.springboot2.mybatis.model.TUser;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.formula.functions.T;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration

@EnableTransactionManagement
@MapperScan(basePackages = "com.maduar.springboot2.mybatis.dao", sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestSqlConfig {

	final String MAPPER_PATH = "classpath:mapper/**.xml";
	final String TYPE_HANDLER_PATH = "com.maduar.springboot2.mybatis.thander";

	@Autowired
    private Environment env;

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

        Boolean camelCaseBoolean = Boolean.valueOf(env.getProperty("mybatis.mapUnderscoreToCamelCase"));
        Class<T>[] tClass = new Class[]{KEmail.class, SexEnum.class, TUser.class};

        // set mybatis configuration
        org.apache.ibatis.session.Configuration mybatisConfig = new org.apache.ibatis.session.Configuration();
        mybatisConfig.setMapUnderscoreToCamelCase(camelCaseBoolean);
        sessionFactory.setConfiguration(mybatisConfig);

        sessionFactory.setTypeHandlersPackage(TYPE_HANDLER_PATH);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_PATH));
        sessionFactory.setDataSource(testDataSource);
        sessionFactory.setTypeAliases(tClass);

        return sessionFactory.getObject();
    }

}
