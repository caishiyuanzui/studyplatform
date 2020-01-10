package com.zqu.ljt.studyplatform.authentication;

import com.zqu.ljt.studyplatform.Untils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xiuming Lee
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //获取JWT
        String authHeader = request.getHeader("Authorization");
        logger.info("--------->"+authHeader);
        if (authHeader != null) {
            JwtUtils.tokenParser(authHeader);
        }
        filterChain.doFilter(request, response);
    }
}
