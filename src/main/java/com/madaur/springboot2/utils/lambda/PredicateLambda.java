package com.madaur.springboot2.utils.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/*
 * description:
 * @author maduar
 * @date 20/01/2019
 * @email maduar@163.com
 *
 * */
public class PredicateLambda {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = Lists.newArrayList();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
