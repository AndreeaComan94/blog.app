package com.echo.blog.controls;

/**
 * Created by UserA on 7/24/2015.
 */

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

        public void init(FilterConfig filterConfig) throws ServletException {
        }

        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            response.setHeader("Access-Control-Allow-Headers", "content-type");
            chain.doFilter(req, res);
        }

        public void destroy() {
        }

    }