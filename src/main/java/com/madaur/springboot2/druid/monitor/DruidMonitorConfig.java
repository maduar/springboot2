package com.madaur.springboot2.druid.monitor;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/*
 * description:
 * @author maduar
 * @date 18/12/2018 2:44 PM
 * @email maduar@163.com
 *
 * */
@SpringBootConfiguration
public class DruidMonitorConfig {

  private static final Logger logger = LoggerFactory.getLogger(DruidMonitorConfig.class);

  final String druidName = "admin";
  final String druidPwd = "druidPassword";

  @Bean
  public ServletRegistrationBean servletRegistrationBean() {
    logger.info("init Druid Monitor Servlet ...");
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
      "/druid/*");
//    // IP白名单
    servletRegistrationBean.addInitParameter("allow", "");
//    // IP黑名单(共同存在时，deny优先于allow)
    servletRegistrationBean.addInitParameter("deny", "");
    // 控制台管理用户
    servletRegistrationBean.addInitParameter("loginUsername", druidName);
    servletRegistrationBean.addInitParameter("loginPassword", druidPwd);
    // 是否能够重置数据 禁用HTML页面上的“Reset All”功能
    servletRegistrationBean.addInitParameter("resetEnable", "false");
    return servletRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    return filterRegistrationBean;
  }

}
