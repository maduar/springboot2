package com.madaur.springboot2.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 * description:
 * @author maduar
 * @date 20/01/2019
 * @email maduar@163.com
 *
 * */
@Setter
@Getter
public class Apple {
    private String weight;

    public Apple(String weight) {
        this.weight = weight;
    }

    public Apple() {
    }
}
