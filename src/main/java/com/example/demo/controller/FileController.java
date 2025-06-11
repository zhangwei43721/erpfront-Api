package com.example.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {

    private static final String UPLOAD_DIR = "uploads/imgs/";

    @PostMapping("/uploadImg")
    public String uploadImg(MultipartFile file) {
        // 检查文件是否为空
        if (file == null || file.isEmpty()) {
            return "文件为空";
        }

        // 获取原始文件名
        String originalName = file.getOriginalFilename();
        if (originalName == null) {
            return "文件名无效";
        }

        // 生成新文件名
        String uuid = UUID.randomUUID().toString();
        String ext = originalName.substring(originalName.lastIndexOf("."));
        String newName = uuid + ext;
        System.out.println("新文件名: " + newName);

        // 创建保存目录
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 创建目标文件
        File target = new File(dir, newName);
        try {
            // 保存文件
            FileUtils.copyInputStreamToFile(file.getInputStream(), target);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败: " + e.getMessage();
        }

        // 返回访问 URL
        return "http://localhost:8080/uploads/imgs/" + newName;
    }
}