package com.madaur.springboot2.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.madaur.springboot2.form.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/*
 * description:
 * @author maduar
 * @date 24/01/2019
 * @email maduar@163.com
 *
 * */
@RestController
@CrossOrigin
@Slf4j
public class TestController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping("/index/{name}/")
    public String test(@PathVariable("name") String name) throws Exception {

        uuid("cococ");

//        String uuid = completableFuture.get();

        String dogName = getDog().get();

        return "test" + name + " , /n " + dogName;
    }

    /**
     * @return
     */
    @Async("myTaskExecutor")
    public static CompletableFuture<String> uuid(String str) throws Exception {
        String result = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("str: " + str);
        throw new Exception("hahahah");

    }

    @Async("myTaskExecutor")
    public CompletableFuture<String> getDog() {
        Dog dog = new Dog("sam", 1);
        dog = null;

        return CompletableFuture.completedFuture(dog).thenApply(Dog::getName);
    }

    @GetMapping("/get/name")
    public String getName() {
        return "useLocalCache: " + useLocalCache;
    }
}
