package ru.gleb.company.command;

import ru.gleb.company.general.BotAPI;
import ru.gleb.company.model.Message;
import ru.gleb.company.method.SendMessage;

public class HelpCommand implements CommandHandler {
	@Override
	public void handle(Message msg, BotAPI bot, String params) {
		int chatId = msg.getChat().getId();
		bot.executeMethod(new SendMessage(chatId, "this is help command, " + params));
	}
}