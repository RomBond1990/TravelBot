package com.rbondarovich;

import com.rbondarovich.commands.service.StartCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TravelBot extends TelegramLongPollingCommandBot {

    @Value("${bot.name}")
    private String BOT_NAME;

    @Value("${bot.token}")
    private String BOT_TOKEN;

    private final NonCommand nonCommand;

    @PostConstruct
    private void init () {
        register(new StartCommand("start", "Старт"));
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }


    public void processNonCommandUpdate(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String answer = nonCommand.nonCommandExecute(chatId, message.getText());
        setAnswer(chatId, answer);
    }

    public void setAnswer(Long chatId, String text) {
        SendMessage answer = new SendMessage();
        answer.setText(text);
        answer.setChatId(chatId.toString());

        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void onUpdateReceived(Update update) {
//        Message message = update.getMessage();
//        Long chatId = message.getChatId();
//        setAnswer(chatId, "hi");
//    }
}
