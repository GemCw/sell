package com.gem.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @Author Gem
 * @Date 2020/2/23 9:35
 */
@Data
public class ResultVO<T> {

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;
}
