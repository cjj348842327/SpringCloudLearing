package com.example.dynamicfilter.filter.post

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.apache.log4j.Logger

import javax.servlet.http.HttpServletResponse

class PostFilter extends ZuulFilter {

    final Logger logger = Logger.getLogger(getClass());

    @Override
    String filterType() {
        return "post";
    }

    @Override
    int filterOrder() {
        return 2000;
    }

    @Override
    boolean shouldFilter() {
        return true;
    }

    @Override
    Object run() {
        logger.info("this is a post filter: Receive response");
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        try{
            response.getOutputStream().print(", I am cjj");
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
