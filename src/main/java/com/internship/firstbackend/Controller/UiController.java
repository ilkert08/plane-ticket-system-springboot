package com.internship.firstbackend.Controller;


import com.internship.firstbackend.model.Airport;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

@RestController
public class UiController {



    @GetMapping("/htmltest")
    public String htmlTest(){

        return "selam";
    }

    @GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() throws IOException {

        File file = ResourceUtils.getFile("classpath:static/example.html");

        //Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
        String temp = "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
        return content;
    }

    @RequestMapping("/offerView")
    public String page(){
        return "example";
    }



}
