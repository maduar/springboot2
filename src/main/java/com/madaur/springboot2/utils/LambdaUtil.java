package com.madaur.springboot2.utils;

import com.madaur.springboot2.utils.lambda.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * description:
 * @author maduar
 * @date 16/01/2019
 * @email maduar@163.com
 *
 * */
public class LambdaUtil {

    public static void process(Runnable r) {
        r.run();
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{

        String filename = "/Users/maduar/git/springboot2/test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return p.process(br);
        }
    }

}
