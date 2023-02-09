package com.study.toy_springboot.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.toy_springboot.dao.UserListDao;
import com.study.toy_springboot.utils.Paginations;

@Service
public class UserListService {

    @Autowired
    UserListDao userListDao;

    @Autowired
    AttachFileService attachFileService;

    // 리스트
    public Object getList(Object dataMap) {
        String sqlMapId = "UserList.selectFromUsers";
        Object result = userListDao.getList(sqlMapId, dataMap);
        return result;
    }

    // 회원 정보
    public Object getOne(Object dataMap) {
        String sqlMapId = "UserList.selectByUID";
        Object result = userListDao.getOne(sqlMapId, dataMap);
        return result;
    }

    // 정보 수정
    public Object update(Object dataMap) {
        String sqlMapId = "UserList.updateByUID";
        Object result = userListDao.update(sqlMapId, dataMap);
        return result;
    }

    // 정보 수정 후 리스트
    public Object updateAndGetList(Object dataMap) {
        Object result = this.update(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    // 
    public String getGeneratorID() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyyhh:mm:ss");
        String strDate = formatter.format(date);
        return strDate;
    }

    public Object insert(Object dataMap) {
        String sqlMapId = "UserList.insertWithUID";
        Object result = userListDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object insertAndGetList(Object dataMap) {
        Object result = this.insert(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "deleteByUID";
        Object result = userListDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object deleteAndGetList(Object dataMap) {
        Object result = this.delete(dataMap);
        result = this.getList(dataMap);
        return result;

    }

    public Object getTotal(Object dataMap) {
        String sqlMapId = "UserList.selectTotal";
        Object result = userListDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object getListWithPagination(Object dataMap) {
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations", paginations);
        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        ((Map<String, Object>) dataMap).put("pageScale", paginations.getPageScale());
        result.put("resultList", this.getList(dataMap));
        return result;
    }

}