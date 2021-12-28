package com.cgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author GyuanYuan Cai
 * 2021/10/6
 * Description:
 */
@Controller
public class FileUploadController {

    // 单文件上传
    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile filePic) throws IOException {
        //获取表单的提交参数,完成文件上传
        System.out.println(username);
        // 获取上传原始文件名
        String originalFilename = filePic.getOriginalFilename();
        filePic.transferTo(new File("D:/upload/"+originalFilename));
        return "success";
    }

    // 多文件上传
    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile[] filePic) throws IOException {
        //获取表单的提交参数,完成文件上传
        System.out.println(username);
        for (MultipartFile multipartFile : filePic) {
            // 获取上传原始文件名
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:/upload/"+originalFilename));
        }
        return "success";
    }
}