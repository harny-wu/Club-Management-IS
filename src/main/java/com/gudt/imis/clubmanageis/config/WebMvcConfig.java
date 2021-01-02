package com.gudt.imis.clubmanageis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName : WebMvcConfig
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-23 20:41
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 资源映射路径
         * addResourceHandler：访问映射路径
         * addResourceLocations：资源绝对路径
         */
        registry.addResourceHandler("/clubImg/**").addResourceLocations("file:/springbootProject/club/image/clubImg/");
        registry.addResourceHandler("/userImg/**").addResourceLocations("file:/springbootProject/club/image/userImg/");
    }
}
