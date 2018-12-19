package com.lizx.springcloud.controller;

import com.lizx.springcloud.BaseApiService;
import com.lizx.springcloud.ResponseBase;
import com.lizx.springcloud.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lzx on 2018-12-17.
 */
@RestController
public class FristMemberController extends BaseApiService {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/orderToMember")
    public UserEntity orderToMember(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("会员服务端口："+serverPort);
        userEntity.setAge(10);
        System.out.println("会员服务调用成功》》》》》》》》》》》》》》》》");
        return userEntity;
    }

    @RequestMapping("/orderToMemberHystrix")
    public ResponseBase orderToMemberHystrix(){
        //Hystrix默认调用时间1s，超过1s实现服务降级调用服务降级的方法，
        // 可以设置 或者 禁用超时时间，正常情况不能开启禁用超市时间
        /*try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("...........................................");
        return setResultSuccess("成功....");
    }
}
