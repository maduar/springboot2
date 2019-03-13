package com.madaur.springboot2.bean;

import com.madaur.springboot2.utils.SpringTools;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/*
 * description:
 * @author maduar
 * @date 12/01/2019
 * @email maduar@163.com
 *
 * */
@Configuration
@EnableAsync
public class ConfigBean {

    @Bean
    public SpringTools initSpringTools() {
        return new SpringTools();
    }

    @Lazy
    @Bean(name = "javaMailSender")
    @ConfigurationProperties(prefix = "spring.mail")
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        return new JavaMailSenderImpl();
    }

}
