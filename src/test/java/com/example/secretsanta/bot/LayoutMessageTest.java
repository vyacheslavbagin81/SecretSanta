package com.example.secretsanta.bot;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LayoutMessageTest {

    @Test
    void testLayoutMessage() {
        LayoutMessage layoutMessage = new LayoutMessage();
        Long chatId = 1L;
        String textToSend = "Hello, World!";
        SendMessage expected = SendMessage.builder()
                .chatId(chatId)
                .text(textToSend)
                .build();

        SendMessage actual = layoutMessage.layoutMessage(chatId, textToSend);

        assertEquals(expected, actual);
    }

    @Test
    void testLayoutMessageWithAButton() {
        LayoutMessage layoutMessage = new LayoutMessage();
        Long chatId = 2L;
        String textToSend = "Howdy, Partner!";

        // спорное решение
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Кнопка");
        inlineKeyboardButton1.setCallbackData("18");
        buttons1.add(inlineKeyboardButton1);
        buttons.add(buttons1);
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        SendMessage expected = SendMessage.builder()
                .chatId(chatId)
                .text(textToSend)
                .replyMarkup(markupKeyboard)
                .build();

        SendMessage actual = layoutMessage.layoutMessageWithAButton(chatId, textToSend);

        assertEquals(expected, actual);
    }
}