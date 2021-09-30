package com.soumitra.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.activation.FileTypeMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author soumitragoswami
 */
@RestController
@RequestMapping(value = "/test")
public class MyDemoController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getController() {
        MyClass myObj = new MyClass();
        myObj.setVal("this is a test");
        return new ResponseEntity<>(myObj, HttpStatus.OK);

    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getImage() throws IOException {
        File img = new File("/home/soumitragoswami/Pictures/IMG_20180920_140248_Bokeh.jpg");
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }
}

class MyClass {

    private String val;

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return this.val;
    }
}
