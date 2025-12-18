package com.ecommerce.ecommerceProject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService{
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //file names of original file
        String originalFileName = file.getOriginalFilename();
        //generate a unique file name
        String randomId = UUID.randomUUID().toString();
        //example -mat.jbg  random id=1234 ans=1234.jpg
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = path + File.pathSeparator + fileName;
        //check if path exists ,if not create

        File folder = new File(path);
        if (!folder.exists())
            folder.mkdir();
        //upload to the server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }
}
