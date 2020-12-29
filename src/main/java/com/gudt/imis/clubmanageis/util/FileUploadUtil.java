package com.gudt.imis.clubmanageis.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName : FileUploadUtil
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-23 19:59
 */
@Component
public class FileUploadUtil {

    public static String UploadFile(MultipartFile uploadFile,String path){
        //获取上传文件的名称
        String fileName = uploadFile.getOriginalFilename();
        //解决文件重名问题
        String finalFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
        path=path+finalFileName;
        try {
            uploadFile.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return finalFileName;
    }
}