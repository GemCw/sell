package com.gem.sell.utils;/**
 * @Author Gem
 * @Date 2020/2/27 17:45
 */

import com.gem.sell.enums.CodeEnum;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/2/27 17:45
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
