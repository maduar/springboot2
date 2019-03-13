package com.madaur.springboot2.utils.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/*
 * description:
 * @author maduar
 * @date 16/01/2019
 * @email maduar@163.com
 *
 * */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
