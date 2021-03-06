package com.msj.blog.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msj.blog.response.MsgTable;
import com.msj.blog.response.Response;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * zbj: create on 2018/08/02 10:18
 */
@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler{

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.info("login fail [{}:{}]", request.getParameter("username"), request.getParameter("password"));
        response.setContentType("application/json;charset=UTF-8");
        @Cleanup PrintWriter writer = response.getWriter();
        Response<String> res = new Response<>();
        res.setMsg(MsgTable.USERNAME_OR_PASSWORD_ERROR);
        writer.write(objectMapper.writeValueAsString(res.fail()));
    }
}
