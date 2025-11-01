package com.Fredly.service.authenticator;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.Fredly.service.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        if (CookieService.getCookie(request,"usuarioEmail") != null) {
            return true;
        } else {
            try {
                response.sendRedirect("/loginUsuario");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
            
        }
    }

}
