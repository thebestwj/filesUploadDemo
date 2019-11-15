package com.zju.demo.filesupload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by white_wolf on 2019/11/15.
 *
 * @author thebestwj
 */
public interface FilesService {
    void saveFile(MultipartFile file,String filename);
}
