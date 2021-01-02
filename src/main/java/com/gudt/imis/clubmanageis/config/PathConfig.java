package com.gudt.imis.clubmanageis.config;

import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : FilePathConfig
 * @Description : 文件路径
 * @Author : WDD
 * @Date: 2020-12-29 13:44
 */
@Configuration
public class PathConfig {
    public static final String MYURL="";
    public static final String UPLOADFILEPATH="/springbootProject/club/image/";
    public static final String CLUBUPLOADFILEPATH=UPLOADFILEPATH+"clubImg/";
    public static final String CLUBUPLOADPATHMAPPING="clubImg/";
    public static final String USERUPLOADFILEPATH=UPLOADFILEPATH+"userImg/";
    public static final String USERUPLOADPATHMAPPING="userImg/";
}
