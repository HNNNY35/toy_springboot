package com.study.toy_springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.toy_springboot.service.UserListService;

@Controller
public class MainController {

    @Autowired
    UserListService userListService;

    @RequestMapping(value = { "/main", "/", "" }, method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = { "/listPagination/{currentPage}" }, method = RequestMethod.GET)
    public ModelAndView listPagination(@RequestParam Map<String, Object> params, @PathVariable String currentPage,
            ModelAndView modelAndView) {
        params.put("currentPage", Integer.parseInt(currentPage));
        Object resultMap = userListService.getListWithPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("userlist");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUp(ModelAndView modelAndView) {

        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String userId,
            ModelAndView modelAndView) {
        params.put("USER_ID", userId);
        Object resultMap = userListService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("signup");

        return modelAndView;
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userListService.getList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/listPagination/1");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userListService.updateAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/listPagination/1");
        return modelAndView;

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        String userId = userListService.getGeneratorID();
        params.put("USER_ID", userId);
        Object resultMap = userListService.insertAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/listPagination/1");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Map<String, Object> params, @PathVariable String userId,
            ModelAndView modelAndView) {
        params.put("USER_ID", userId);
        Object resultMap = userListService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("/listPagination/1");
        return modelAndView;

    }

}