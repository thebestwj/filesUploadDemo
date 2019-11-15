package com.zju.demo.filesupload.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;

/**
 * Created by white_wolf on 2019/11/15.
 *
 * @author thebestwj
 */
@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() throws IOException {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制
        factory.setMaxFileSize(DataSize.parse("8MB")); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("2MB"));
        Resource resource = new ClassPathResource("");
        factory.setLocation(resource.getFile().getAbsolutePath());
        return factory.createMultipartConfig();
    }
}
