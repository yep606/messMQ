package ru.stomprf.config;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SetWebhook;
import com.pengrad.telegrambot.response.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BotInitializer {

    @Value("${BOT_TOKEN}")
    private String token;

    @PostConstruct
    public void init(){
        TelegramBot bot = new TelegramBot(token);
        SetWebhook request = new SetWebhook().url("");
        BaseResponse response = bot.execute(request);
        boolean ok = response.isOk();
        System.out.println("WEBHOOK is: " + ok);
    }

}
