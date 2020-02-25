package com.gem.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Gem
 * @Date 2020/2/25 18:39
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法。。。。");
        log.info("code={}",code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxbd411b9ed8302b87&secret=70240bc9a8794ed5e64ed5337a794d50&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);
    }






    @GetMapping("/tomanman")
    public String auth2(){
        log.info("邱妮打开了一次网页。。。。");
        return "请永远铭记，我爱你，小曼曼";
    }
    @GetMapping("/tofrank")
    public String auth3(){
        log.info("进入auth方法333。。。。");
        return "请永远铭记，我爱你，小国国";
    }


}
