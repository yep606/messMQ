package ru.stomprf.controller;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @Autowired
    public WebhookController(){
    }

    @PostMapping("/")
    public void webhook(@RequestBody String request){
        Update update = BotUtils.parseUpdate(request);
        System.out.println(update.message().text());
    }

}
