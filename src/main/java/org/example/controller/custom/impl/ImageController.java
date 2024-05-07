package org.example.controller.custom.impl;

import org.example.dto.DriveResponseDto;
import org.example.service.custom.impl.DriveUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

@CrossOrigin
@RestController
public class ImageController {
    @Autowired
    private DriveUploadServiceImpl service;
    @PostMapping("/upload")
    public Object handleFileUpload(@RequestParam("image") MultipartFile file) throws IOException, GeneralSecurityException {
        if (file.isEmpty()) {
            return "FIle is empty";
        }
        File tempFile = File.createTempFile("temp", null);
        file.transferTo(tempFile);
        DriveResponseDto res = service.uploadImageToDrive(tempFile);
        System.out.println(res);
        return res;
    }

//    @PostMapping("/upload")
//    public String handleFileUpload(@RequestParam("image") MultipartFile file) {
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                // Change the path where you want to store the image
//                File storedFile = new File("/path/to/store/images/" + file.getOriginalFilename());
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(storedFile));
//                stream.write(bytes);
//                stream.close();
//                return "Image uploaded successfully!";
//            } catch (Exception e) {
//                return "Failed to upload image: " + e.getMessage();
//            }
//        } else {
//            return "Failed to upload image: File is empty";
//        }
//    }
}
