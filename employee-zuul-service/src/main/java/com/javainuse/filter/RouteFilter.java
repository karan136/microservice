package com.javainuse.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RouteFilter extends ZuulFilter {

	@Autowired
	private ProxyRequestHelper helper;
	
	@Override
	public String filterType() {
		return "route";
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
		System.out.println("Using Route Filter");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(request.getHeader("Authorization"));
		System.out.println(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
		return null;
	}

}