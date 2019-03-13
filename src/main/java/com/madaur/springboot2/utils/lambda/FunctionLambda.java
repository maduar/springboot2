package com.madaur.springboot2.utils.lambda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * description:
 * @author maduar
 * @date 20/01/2019
 * @email maduar@163.com
 *
 * */
public class FunctionLambda {

    public static <T, R> List<R> filter(List<T> list, Function<T, R> f) {
        List<R> result = Lists.newArrayList();
        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }
}
