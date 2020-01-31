package com.example.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

public class ErrorExtFilter extends SendErrorFilter {

    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
        if(failedFilter != null && failedFilter.filterType().equals("post")){
            return true;
        }
        return false;
    }
}
