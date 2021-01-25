package ru.gleb.company;

import ru.gleb.company.command.CommandHandler;
import ru.gleb.company.general.BotAPI;
import ru.gleb.company.general.UpdateHandler;
import ru.gleb.company.general.CallbackQueryHandler;
import ru.gleb.company.model.*;
import ru.gleb.company.method.GetMe;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Arrays;
import java.util.function.Predicate;

public class Bot implements UpdateHandler {
	private static int CURRENT_HASH = 0;
	private String botToken;
	private BotAPI botAPI;
	private String botUsername;
	private Map<String, CommandHandler> commands;
	private Map<Integer, RegisteredCallbackQueryHandler> callbackHandlers;

	public Bot(String botToken) {
		this.botAPI = new BotAPI(botToken);
		this.botToken = botToken;
		this.commands = new HashMap<>();
		this.callbackHandlers = new HashMap<>();
		this.botUsername = botAPI.executeMethod(new GetMe()).getUsername();
	}

	public void start() {
		System.out.println("Start...");
		startListenUpdates();
	}

	public void handleUpdate(Update update) {
		System.out.println(update);
		if (update.hasMessage()) {
			Message message = update.getMessage();
			if (message.hasEntities()) {
				MessageEntity command = Arrays.stream(message.getEntities()).filter(entity -> entity.getType().equals("bot_command") && entity.getOffset() == 0)
					.findAny().orElse(null);
				if (command != null) {
					String commandName = message.getText().substring(1, command.getLength()); // command without '/'
					String[] commandParts = commandName.split("@");
					commandName = commandParts[0]; // command without bot name
					if (commandParts.length == 2 && !commandParts[1].equals(botUsername)) // not accept command if the command was addressed another bot
						return;
					String params = message.getText().substring(command.getLength());
					if (params.startsWith(" ") || params.equals("")) { // not accept if message is invalid
						params = params.trim();
						executeCommand(message, commandName, params);
					}
				}
 			}
		}
		if (update.hasCallbackQuery()) {
			CallbackQuery callbackQuery = update.getCallbackQuery();
			callbackHandlers.entrySet().stream()
					.filter(handler -> handler.getValue().getPredicate().test(callbackQuery))
					.forEach(handler -> handler.getValue().getHandler()
							.handle(callbackQuery, botAPI, () -> unregisterCallbackQueryHandler(handler.getKey())));
		}
	}

	public void registerBotCommand(CommandHandler command, String commandName) {
		Objects.requireNonNull(commandName, "command name must not be null");
		Objects.requireNonNull(command, "command must not be null");
		commands.put(commandName, command);
	}

	public int registerCallbackQueryHandler(CallbackQueryHandler handler, Predicate<CallbackQuery> predicate) {
		Objects.requireNonNull(handler);
		Objects.requireNonNull(predicate);
		callbackHandlers.put(++CURRENT_HASH, new RegisteredCallbackQueryHandler(predicate, handler));
		return CURRENT_HASH;
	}

	public void unregisterCallbackQueryHandler(int hash) {
		callbackHandlers = callbackHandlers.entrySet().stream().filter(h -> h.getKey() != hash).collect(HashMap::new, (a, b) -> a.put(b.getKey(), b.getValue()), HashMap::putAll);
	}

	private void executeCommand(Message message, String commandName, String params) {
		CommandHandler commandHandler = commands.get(commandName);
		if (commandHandler != null)
			commandHandler.handle(message, botAPI, params);
	}

	private void startListenUpdates() {
		botAPI.startListenUpdates(this);
	}

	public String getBotToken() {
		return botToken;
	}

	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}

	private static class RegisteredCallbackQueryHandler {
		private Predicate<CallbackQuery> predicate;
		private CallbackQueryHandler handler;

		public RegisteredCallbackQueryHandler(Predicate<CallbackQuery> predicate, CallbackQueryHandler handler) {
			this.predicate = predicate;
			this.handler = handler;
		}

		public Predicate<CallbackQuery> getPredicate() {
			return predicate;
		}

		public CallbackQueryHandler getHandler() {
			return handler;
		}
	}
}