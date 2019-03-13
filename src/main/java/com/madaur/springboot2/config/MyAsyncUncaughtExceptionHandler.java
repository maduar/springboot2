package com.madaur.springboot2.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * Description: 
 * 
 * @author maduar maduar@163.com
 * @version 1.1.1 2019-01-24 
 * 
 */
@Configuration
@Slf4j
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler{

    /**
    *
    *
    *@author maduar
    *@version 1.1.1 2019-01-24
    *@Param throwable the exception thrown from the asynchronous method
    *@Param method the asynchronous method
    *@Param params the parameters used to invoked the method
    *@return
    *@exception
    *@throws
    *
    */
    
    /**
     * note: 
     * 
     * @author maduar
     * @version 1.1.1 2019-01-24
     * @Param
     * @return 
     * @exception 
     * @throws
     *
     */
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {

        String methodName = method.getName();
        log.info("methodName: " + methodName);

        JSONArray jsonData = JSON.parseArray(String.valueOf(objects));
        log.info("jsonData: " + jsonData);

        log.error(methodName + ": " + throwable.getMessage());

    }
}
