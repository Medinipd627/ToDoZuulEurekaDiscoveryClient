package com.bridgelabz.eureka.zuul;

/********************************************************************************
 * Created By:Medini P.D
 * Date:- 10/08/2018
 * Purpose:Simple filter implementation for the zuul Eureka Server
 **********************************************************************************/

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getRequestURI().matches("(.*)/note(.*)"))
		// if(request.getMethod().equalsIgnoreCase("note"))
		{
			String userId = JWToken.verifyToken(request.getHeader("Authorization")).getIssuer();
			// request.setAttribute("Authorization", userId);
			ctx.set(userId);
			System.out.println("userid is" + userId);
		}
		return null;
	}
}