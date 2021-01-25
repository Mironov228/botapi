package ru.gleb.company.general;

import ru.gleb.company.model.CallbackQuery;

public interface CallbackQueryHandler {
	void handle(CallbackQuery query, BotAPI bot, Runnable unregister);
}