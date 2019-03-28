package com.tinder.Filters;


import com.tinder.Cookies.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterServletAnybodyLogged implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!new Session(servletRequest).isAnybodyLogged()) {
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
