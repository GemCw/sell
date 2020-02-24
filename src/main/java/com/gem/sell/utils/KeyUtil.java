package com.gem.sell.utils;

import java.util.Random;

/**
 * @Author Gem
 * @Date 2020/2/23 17:38
 */
public class KeyUtil {

    /**
     * 生成唯一的六位数主键
     * 格式: 时间 + 随机数
     * synchronized:防止多线程并发
     * */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        return  System.currentTimeMillis() + String.valueOf(number);
    }
}
