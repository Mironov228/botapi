package ru.gleb.company.command;

import ru.gleb.company.general.BotAPI;
import ru.gleb.company.model.Message;

public interface CommandHandler {
	void handle(Message message, BotAPI botAPI, String params);
}