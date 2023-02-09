package com.study.toy_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.toy_springboot.dao.CommonCodeDao;

@Service
public class CommonCodeService {

    @Autowired
    CommonCodeDao commonCodeDao;

    @Autowired
    AttachFileService attachFileService;

    public Object getList(Object dataMap) {
        String sqlMapId = "CommonCode.selectListByUID";
        Object result = commonCodeDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "CommonCode.selectByUID";
        Object result = commonCodeDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "CommonCode.updateByUID";
        Object result = commonCodeDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object deleteOne(Object dataMap) {
        String sqlMapId = "CommonCode.deleteByUID";
        Object result = commonCodeDao.deleteOne(sqlMapId, dataMap);
        return result;
    }

    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "CommonCode.deleteMultiByUIDs";
        Object result = commonCodeDao.deleteOne(sqlMapId, dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "CommonCode.insertWithUID";
        Object result = commonCodeDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object deleteAndGetList(Object dataMap) {
        Object result = this.deleteOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }

    public Object updateAndGetList(Object dataMap) {
        Object result = this.updateOne(dataMap);
        result = this.getList(dataMap);
        return result;

    }

    public Object insertWithFilesAndGetList(Object dataMap) {
        // insert files
        Object result = attachFileService.insertMulti(dataMap);
        result = this.insertOne(dataMap);
        result = this.getList(dataMap);
        return result;
    }
}