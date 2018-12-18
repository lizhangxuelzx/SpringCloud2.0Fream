package com.lizx.springcloud.fallback;

import com.lizx.springcloud.BaseApiService;
import com.lizx.springcloud.ResponseBase;
import com.lizx.springcloud.entity.UserEntity;
import com.lizx.springcloud.feignService.orderToMemberFeign;
import org.springframework.stereotype.Component;


/**
 * Created by lzx on 2018-12-17.
 */
@Component
public class MemberFallbacks extends BaseApiService implements orderToMemberFeign {

    //踩坑：少了Component，导致8001无法启动

    @Override
    public UserEntity orderToMember() {
        return null;
    }

    @Override
    public ResponseBase orderToMemberHystrix() {
        return setResultError("服务器忙,请稍后重试!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
