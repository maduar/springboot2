package com.madaur.springboot2.utils.lambda;

import java.util.List;
import java.util.function.Consumer;

/*
 * description:
 * @author maduar
 * @date 20/01/2019
 * @email maduar@163.com
 *
 * */
public class ConsumerLambda {

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
