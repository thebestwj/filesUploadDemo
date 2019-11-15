package com.zju.demo.filesupload.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by white_wolf on 2019/11/15.
 *
 * @author thebestwj
 */
@Slf4j
@Service
public class FilesServiceImp  implements FilesService{
    @Override
    public void saveFile(MultipartFile file, String filename) {
        if (file.isEmpty()) {
            log.warn("空文件");
            return;
        }

        try {
            File dest = new File(filename);
            file.transferTo(dest);
            log.info("上传成功");

        } catch (IOException e) {
            log.error(e.toString(), e);
        }

    }
}
