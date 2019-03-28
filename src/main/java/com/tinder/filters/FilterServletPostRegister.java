package com.tinder.filters;

import com.tinder.servlets.RegisterServlet;
import com.tinder.utils.Params;

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
        if (httpRequest.getMethod().equalsIgnoreCase("POST")
                && !new Params(httpRequest).containsAll(RegisterServlet.f_lg, RegisterServlet.f_pw, RegisterServlet.f_lg, RegisterServlet.f_fn, RegisterServlet.f_ph)) {
            ((HttpServletResponse) servletResponse).sendRedirect("/register");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
