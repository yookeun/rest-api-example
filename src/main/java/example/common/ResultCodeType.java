package example.common;

import lombok.Getter;

/**
 * Created by yookeun on 2017. 2. 26..
 */

public enum ResultCodeType {
    SUCCESS(0, "success"),
    FAIL_REQUEST(1, "fail request");

    @Getter
    private int code;

    @Getter
    private String msg = "success";

    ResultCodeType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
