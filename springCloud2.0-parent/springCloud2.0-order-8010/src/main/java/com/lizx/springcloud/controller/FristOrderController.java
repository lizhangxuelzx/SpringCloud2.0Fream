package com.lizx.springcloud.controller;

import com.lizx.springcloud.BaseApiService;
import com.lizx.springcloud.ResponseBase;
import com.lizx.springcloud.entity.UserEntity;
import com.lizx.springcloud.feignService.orderToMemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lzx on 2018-12-17.
 */
@RestController
public class FristOrderController extends BaseApiService{

    @Autowired
    private orderToMemberFeign  orderToMemberFeign;


    @RequestMapping("/orderToMember")
    public UserEntity orderToMember(){
        UserEntity userEntity = orderToMemberFeign.orderToMember();
        System.out.println("当前线程池名称0："+Thread.currentThread().getName());
        return userEntity;
    }

    @RequestMapping("/orderToMemberHystrix")
    public ResponseBase orderToMemberHystrix(){
        System.out.println("当前线程池名称1："+Thread.currentThread().getName());
        return orderToMemberFeign.orderToMemberHystrix();
    }
}
