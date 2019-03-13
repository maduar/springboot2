package com.madaur.springboot2.form;

import com.google.common.collect.ComparisonChain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Description: 
 * 
 * @author maduar maduar@163.com
 * @version 1.1.1 2019-01-25 
 * 
 */
@Data
@AllArgsConstructor
@ToString
public class Dog implements Comparable<Dog>{
    private String name;
    private int age;

    @Override
    public int compareTo(Dog that) {
        return ComparisonChain.start()
                .compare(this.name, that.name)
                .compare(this.age, that.age)
                .result();
    }
}
