package com.zju.demo.filesupload.controller;

import com.zju.demo.filesupload.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by white_wolf on 2019/11/15.
 *
 * @author thebestwj
 */
@RestController
public class DefaultController {

    @Autowired
    FilesService filesService;

    @RequestMapping("/upload")
    String upload(HttpServletRequest request) {
        int count = 0;
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        System.out.println(files.size());
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = null;
            file = files.get(i);
            if (file.getSize() == 0) continue;
            Date date = new Date();
            filesService.saveFile(file,String.valueOf(i) + date.getTime() + file.getOriginalFilename());
            count++;
        }
     return "success upload " + count +" files";
    }
}
