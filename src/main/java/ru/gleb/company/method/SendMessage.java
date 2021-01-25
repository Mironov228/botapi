package ru.gleb.company.method;

import ru.gleb.company.model.keyboard.Keyboard;
import ru.gleb.company.model.Message;
import ru.gleb.company.model.mapper.MessageMapper;
import ru.gleb.company.model.mapper.Mapper;
import java.util.Optional;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class SendMessage implements Method<Message> {
	private int chatId;
	private String text;
	private Optional<String> parseMode;
	private Optional<Keyboard> replyMarkup;
	private Optional<Integer> replyToMessageId;
	private Optional<Boolean> disableNotification;

	public SendMessage(int chatId, String text) {
		setChatId(chatId);
		setText(text);
		parseMode = Optional.empty();
		replyMarkup = Optional.empty();
		replyToMessageId = Optional.empty();
		disableNotification = Optional.empty();
	}

	public SendMessage(int chatId, String text, String parseMode) {
		this(chatId, text);
		Objects.requireNonNull(parseMode, "the parse_mode mustn't be null");
		this.parseMode = Optional.of(parseMode);
	}

	public SendMessage(int chatId, String text, int replyToMessageId) {
		this(chatId, text);
		setReplyToMessageId(replyToMessageId);
	}

	public SendMessage(int chatId, String text, Keyboard replyMarkup) {
		this(chatId, text);
		setReplyMarkup(replyMarkup);
	}

	public int getChatId() { return chatId; }
	public void setChatId(int arg) { chatId = arg; }

	public String getText() { return text; }
	public void setText(String text) {
		Objects.requireNonNull(text, "the text mustn't be null");
		this.text = text;
	}

	public Optional<String> getParseMode() { return parseMode; }
	public void setParseMode(String parseMode) {
		Objects.requireNonNull(parseMode, "the parse_mode must not be null");
		this.parseMode = Optional.of(parseMode);
	}

	public Optional<Keyboard> getReplyMarkup() { return replyMarkup; }
	public void setReplyMarkup(Keyboard replyMarkup) {
		Objects.requireNonNull(replyMarkup, "the replyMarkup mustn't be null");
		this.replyMarkup = Optional.of(replyMarkup);
	}

	public Optional<Integer> getReplyToMessageId() { return replyToMessageId; }
	public void setReplyToMessageId(int replyToMessageId) { 
		this.replyToMessageId = Optional.of(replyToMessageId);
	}

	public Optional<Boolean> getDisableNotification() { return disableNotification; }
	public void setDisableNotification(boolean disableNotification) { this.disableNotification = Optional.of(disableNotification); }

	@Override
	public String methodName() {
		return "sendMessage";
	}

	@Override
	public Mapper<Message> getMapper() {
		return MessageMapper::map;
	}

	@Override
	public Object[] parameters() {
		List<Object> list = new ArrayList<>();
		list.add("chat_id");
		list.add(chatId);
		
		list.add("text");
		list.add(text);
		
		parseMode.ifPresent(parseMode -> {
			list.add("parse_mode");
			list.add(parseMode);
		});
		replyMarkup.ifPresent(replyMarkup -> {
			list.add("reply_markup");
			list.add(replyMarkup.toJSON());
		});
		replyToMessageId.ifPresent(replyToMessageId -> {
			list.add("reply_to_message_id");
			list.add(replyToMessageId);
		});
		disableNotification.ifPresent(disableNotification -> {
			list.add("disable_notification");
			list.add(disableNotification);
		});
		return list.toArray();
	}
}