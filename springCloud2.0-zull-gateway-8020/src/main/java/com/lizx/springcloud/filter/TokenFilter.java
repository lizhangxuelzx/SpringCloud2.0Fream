package com.lizx.springcloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TokenFilter extends ZuulFilter {

	public Object run() throws ZuulException {
        // 获取上下文
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String userToken = request.getParameter("userToken");
		if (StringUtils.isEmpty(userToken)) {
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(401);
			currentContext.setResponseBody("userToken is null");
			return null;
		}
		// 否则正常执行业务逻辑.....
		return null;
	}

	// 判断过滤器是否生效
	public boolean shouldFilter() {

		return true;
	}
	String s1="";
	// 过滤器的执行顺序。当请求在一个阶段的时候存在多个多个过滤器时，需要根据该方法的返回值依次执行
	public int filterOrder() {

		return 0;
	}

	// 过滤器类型 pre 表示在 请求之前进行拦截
	public String filterType() {

		return "pre";
	}

}