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
    public static final String MYURL="http://8.129.215.86:8084/";
    public static final String UPLOADFILEPATH="/springbootProject/club/image/";
    public static final String CLUBUPLOADFILEPATH=UPLOADFILEPATH+"clubImg/";
    public static final String UPLOADPATHMAPPING="clubImg/";
}
