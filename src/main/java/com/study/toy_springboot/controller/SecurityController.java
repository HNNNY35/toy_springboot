package com.study.toy_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class SecurityController {

    // 로그인 폼
    @GetMapping({ "/loginForm" })
    public ModelAndView loginForm(ModelAndView modelAndView) {
      String viewName = "/WEB-INF/views/security/loginForm.jsp";
      modelAndView.setViewName(viewName);
      return modelAndView;
    }
  
     // 로그아웃 폼
    @GetMapping({ "/logoutForm" })
    public ModelAndView logoutForm(ModelAndView modelAndView) {
      String viewName = "/WEB-INF/views/security/logoutForm.jsp";
      modelAndView.setViewName(viewName);
      return modelAndView;
    }
  }