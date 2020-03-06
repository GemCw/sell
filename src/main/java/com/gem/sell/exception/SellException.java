package com.gem.sell.exception;

import com.gem.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @Author Gem
 * @Date 2020/2/23 17:45
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
}
