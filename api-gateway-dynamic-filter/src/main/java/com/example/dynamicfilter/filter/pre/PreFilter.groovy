package com.example.dynamicfilter.filter.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.apache.log4j.Logger

import javax.servlet.http.HttpServletRequest

class PreFilter extends ZuulFilter {
    Logger logger = Logger.getLogger(getClass());

    @Override
    String filterType() {
        return "pre";
    }

    @Override
    int filterOrder() {
        return 1000;
    }

    @Override
    boolean shouldFilter() {
        return true;
    }

    @Override
    Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("this is a pre filter: Send "+request.getMethod()+" request to "+request.getRequestURL().toString());
        return null;
    }
}
