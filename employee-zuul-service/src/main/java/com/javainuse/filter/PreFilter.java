package com.javainuse.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {
	Logger logger = LoggerFactory.getLogger(PreFilter.class);
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		logger.info(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());  
         // Add a custom header in the request
        ctx.addZuulRequestHeader("Authorization",
                 request.getHeader("Authorization"));
        logger.info(String.format("%s request to %s", request.getMethod(), 
                 request.getRequestURL().toString()));
        return null;

	}

}