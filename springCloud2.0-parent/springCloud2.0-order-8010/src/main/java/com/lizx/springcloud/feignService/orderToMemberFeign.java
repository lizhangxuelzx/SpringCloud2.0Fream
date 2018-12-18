package com.lizx.springcloud.feignService;

import com.lizx.springcloud.ResponseBase;
import com.lizx.springcloud.entity.UserEntity;
import com.lizx.springcloud.fallback.MemberFallbacks;
import com.lizx.springcloud.service.ImemberService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lzx on 2018-12-17.
 * 1、Feign默认开启Ribbon，为轮询算法
 * 2、此类也可以不继承ImemberService类，直接在写方法进行调用
 * 3、实现Hystrix降级,通过类的方法实现，也可以采用@HystrixCommand在方法上实现，
 * 4、需配置文件开启hystrix
 */
@FeignClient(value = "springcloud-member", fallback = MemberFallbacks.class)
public interface orderToMemberFeign extends ImemberService{

}
