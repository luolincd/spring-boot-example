package com.tech.court.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tech.court.service.impl.UploadService;
import com.tech.court.util.FileUtil;

import javax.servlet.http.HttpServletRequest;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UploadController {

  @Autowired
  private UploadService uploadService;

  //处理文件上传
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public String uploadImg(@RequestParam("file") MultipartFile file,
      HttpServletRequest request) throws Exception {
    String contentType = file.getContentType();
    String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
    String filePath = request.getSession().getServletContext().getRealPath("upload/");
    log.info("upload file path:{}", filePath);
    try {
      FileUtil.uploadFile(file.getBytes(), filePath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    uploadService.importData(new File(filePath + fileName));
    return "upload success";
  }
}
