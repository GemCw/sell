package com.gem.sell.enums;

import lombok.Getter;

/**
 * @Author Gem
 * @Date 2020/2/23 15:21
 */
@Getter
public enum PayStatusEnum {
    /***/
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
