package com.madaur.springboot2.enums;

/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 21/03/2019
 */
public enum  SexEnum {

    // man - 男
    MALE("1", "男"),

    // woman - 女
    FEMALE("2","女"),
    ;

    public String id;
    public String name;

    SexEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getSex(String id) {
        if ("2".equals(id)) {
            return FEMALE.getName();
        }

        return MALE.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
