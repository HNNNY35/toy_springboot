package com.study.toy_springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.toy_springboot.service.CommonCodeService;
import com.study.toy_springboot.utils.CommonUtils;

// @Controller
public class CommonCodeController {

    @Autowired
    CommonCodeService commonCodeService;

    @Autowired
    CommonUtils commonUtils;

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = commonCodeService.getList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/edit/{uniqueId}" }, method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode/edit");
        return modelAndView;
    }

    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {
        Object resultMap = commonCodeService.updateAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/delete/{uniqueId}" }, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam Map<String, Object> params, @PathVariable String uniqueId,
            ModelAndView modelAndView) {
        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/deleteMulti" }, method = RequestMethod.POST)
    public ModelAndView deleteMulti(HttpServletRequest httpServletRequest, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {

        String[] deleteMultis = httpServletRequest.getParameterMap().get("COMMON_CODE_ID");
        params.put("deleteMultis", deleteMultis);
        Object resultMap = commonCodeService.deleteMulti(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/formMulti" }, method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        modelAndView.setViewName("commonCode/editMulti");
        return modelAndView;
    }

    @RequestMapping(value = { "/insertMulti" }, method = RequestMethod.POST)
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) throws IOException {

        List attachFiles = commonUtils.getAttachFileList(multipartHttpServletRequest, params);

        params.put("attachFiles", attachFiles);

        Object resultMap = commonCodeService.insertWithFilesAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode/list");
        return modelAndView;
    }

}