package com.example.secretsanta.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LayoutMessage {
    /**
     * Метод для формирования сообщения
     * @param chatId = Long id получателя
     * @param textToSend = String текст сообщения
     * @return = SendMessage
     */
    public SendMessage layoutMessage(Long chatId, String textToSend) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId)
                .text(textToSend)
                .build();
        return sendMessage;
    }

    /**
     * Метод для формирования сообщения с кнопкой
     * @param chatId = Long id получателя
     * @param textToSend = String текст сообщения
     * @return = SendMessage
     */
    public SendMessage layoutMessageWithAButton(Long chatId, String textToSend) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatId)
                .text(textToSend)
                .replyMarkup(setInline())
                .build();
        return sendMessage;
    }

    /**
     * Метод для формирования кнопки
     * @return = InlineKeyboardMarkup
     */
    private InlineKeyboardMarkup setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Кнопка");
        inlineKeyboardButton1.setCallbackData("18");
        buttons1.add(inlineKeyboardButton1);
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        return markupKeyboard;
    }
}
