package com.example.secretsanta.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {
    private final LayoutMessage message;

    public Bot(@Value("${bot.token}") String botToken, LayoutMessage message) {
        super(botToken);
        this.message = message;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Long chatId = update.getMessage().getChatId();
            User user = update.getMessage().getFrom();
            String text = user.getUserName() + " " + user.getFirstName() + " " + user.getLastName();
            sendMessage(message.layoutMessage(chatId, text));
        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            String text = update.getCallbackQuery().getData();
            sendMessage(message.layoutMessageWithAButton(chatId, text));
        }

    }

    /**
     * Метод для отправки сообщения пользователю
     * @param message = SendMessage
     */
    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: " + e.getMessage());
        }
    }


    @Override
    public String getBotUsername() {
        return "ShelterSpringDemoBot";
    }

}
