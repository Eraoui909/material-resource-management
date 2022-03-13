package com.gestion_ressource.micro_authentification.Controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/api")
public class TestController {

    @Value("${conf}")
    private String conf;
    @Value("${mail}")
    private String mail;

    @GetMapping("/myConfig")
    public Map<String,String> myConfig(){

        Map<String,String> config = new HashMap<>();

        config.put("conf",conf);
        config.put("mail",mail);

        return config;
    }

    @GetMapping("test")
    public String test(){

        return "success";
    }
}
