package com.study.toy_springboot.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class CommonUtils {

    public String getUniqueSequence() {
        // 유니크아이디생성
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // 파일업로드
    public List getAttachFileList(MultipartHttpServletRequest multipartHttpServletRequest, Map<String, Object> params) {
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        String path = "C:\\Develops\\toy_springboot\\src\\main\\resources\\files\\";

        Map attachFile = null;
        List attachFiles = new ArrayList();
        // 파일 이름 뽑아내기
        String physicalFileName = this.getUniqueSequence();
        String storePath = path + physicalFileName + "\\";
        File newPath = new File(storePath);
        newPath.mkdirs();
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();

            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            String originalFilename = multipartFile.getOriginalFilename();

            String storePathFileName = storePath + originalFilename;
            // 경로 설정
            try {
                multipartFile.transferTo(new File(storePathFileName));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // SOURCE_UNIQUE_SEQ, ORGINALFILE_NAME, PHYSICALFILE_NAME
            attachFile = new HashMap<>();
            attachFile.put("ATTACHFILE_SEQ", this.getUniqueSequence());
            attachFile.put("SOURCE_UNIQUE_SEQ", params.get("COMMON_CODE_ID"));
            attachFile.put("ORGINALFILE_NAME", originalFilename);
            attachFile.put("PHYSICALFILE_NAME", physicalFileName);
            attachFile.put("REGISTER_SEQ", params.get("REGISTER_SEQ"));
            attachFile.put("MODIFIER_SEQ", params.get("MODIFIER_SEQ"));
            attachFiles.add(attachFile);
        }

        return attachFiles;
    }

}