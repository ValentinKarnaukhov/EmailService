package com.javaschool.logistic.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private EmailService emailService;

    private MessageWrapper messageWrapper;

    @Autowired
    public RestController(EmailService emailService, MessageWrapper messageWrapper) {
        this.emailService = emailService;
        this.messageWrapper = messageWrapper;
    }

    @PostMapping(value = "/api/send")
    public String sendMessage(@RequestParam String username,
                              @RequestParam String email,
                              @RequestParam String password){
        try {
            emailService.send(messageWrapper.getMessage(username,email,password),"wippi2010@rambler.ru");
        }catch (Exception e){
            return "BROKEN";
        }
        return "OK";
    }

}
