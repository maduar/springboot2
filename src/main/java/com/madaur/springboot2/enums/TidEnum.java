package com.madaur.springboot2.enums;

/**
 * Description:
 *
 * @author maduar maduar@163.com
 * @version 1.1.1 11/03/2019
 */
public enum TidEnum {

    // TOM
    TOM(1, "TOM"),
    JERY(2, "JERY"),
    ZIGA(22, "ZIGA")
    ;

    private Integer tId;
    private String tName;

    TidEnum(Integer tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public static String getTNameByTid(Integer tId) {
        if (tId == null) {
            return null;
        }

        for (TidEnum tidEnum: TidEnum.values()) {
            if (tId.equals(tidEnum.gettId())) {
                return tidEnum.gettName();
            }
        }

        return null;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
