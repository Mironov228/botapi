package ru.gleb.company;

import ru.gleb.company.method.SendMessage;
import ru.gleb.company.command.*;
import ru.gleb.company.model.keyboard.InlineKeyboardMarkup;
import ru.gleb.company.model.keyboard.InlineKeyboardButton;

public class App {
    public static void main(String[] args) throws Exception {
		Bot bot = new Bot("1069736331:AAFlMhpk6eiS453eyoKtAPdgO41udESD-XQ");
    	bot.registerBotCommand(new HelpCommand(), "help");
    	bot.registerBotCommand((msg, botAPI, params) -> {
    		InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(new InlineKeyboardButton[][] {
    			{new InlineKeyboardButton("+", "11"), new InlineKeyboardButton("+", "12"), new InlineKeyboardButton("+", "13")},
    			{new InlineKeyboardButton("+", "21"), new InlineKeyboardButton("+", "22"), new InlineKeyboardButton("+", "23")},
    			{new InlineKeyboardButton("+", "31"), new InlineKeyboardButton("+", "32"), new InlineKeyboardButton("+", "33")}
    		});
    		SendMessage sendMsg = new SendMessage(msg.getChat().getId(), "PLAY", keyboard);
			botAPI.executeMethod(sendMsg);
    	}, "play");
    	bot.registerCallbackQueryHandler((query, botAPI, unregister) -> {
			botAPI.executeMethod(new SendMessage(query.getMessage().getChat().getId(), query.getData()));
			if (query.getData().equals("33"))
				unregister.run();
		},(query) -> true);
    	bot.start();
	}
}
