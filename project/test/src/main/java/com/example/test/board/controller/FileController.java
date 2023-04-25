package com.example.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.test.board.common.ApiPattern;
import com.example.test.board.service.FileService;

@RestController
@RequestMapping(ApiPattern.FILE)
public class FileController {
    
    @Autowired private FileService fileService; // file/

    private final String UPLOAD = "/upload";
    private final String GET_FILE = "/{fileName}";

    
    @PostMapping(UPLOAD)
    public String upload(@RequestParam("file") MultipartFile file) {
        String response = fileService.upload(file);
        return response;
    }

    @GetMapping(GET_FILE)
    public Resource getFile(String fileName) {
        Resource response = fileService.getFile(fileName);
        return response;
    }



}
