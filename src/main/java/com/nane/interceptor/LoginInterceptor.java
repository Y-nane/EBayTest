package com.nane.interceptor;

import com.nane.exception.BizException;
import com.nane.response.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final String USER_MSG = "X-user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userMsg = request.getHeader(USER_MSG);
        if (StringUtils.isEmpty(userMsg)) {
            throw new BizException(ErrorCode.NO_LOGIN);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
