package com.tinder.Filters;

import com.tinder.Utils.Params;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterServletPostRegister implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        if (httpRequest.getMethod().equalsIgnoreCase("POST")
//                && !new Params(httpRequest).containsAll(ServletRegister.f_p1, ServletRegister.f_p2, ServletRegister.f_lg, ServletRegister.f_gr, ServletRegister.f_nm)) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/register");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
