package com.lizx.springcloud.service;

import com.lizx.springcloud.ResponseBase;
import com.lizx.springcloud.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzx on 2018-12-17.
 */
public interface ImemberService {


    @RequestMapping("/orderToMember")
    public UserEntity orderToMember();

    @RequestMapping("/orderToMemberHystrix")
    public ResponseBase orderToMemberHystrix();
}
