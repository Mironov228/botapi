package ru.gleb.company.model.keyboard;

import java.util.Optional;

public class InlineKeyboardButton {
	private String text;
	private Optional<String> url;
	private Optional<String> callbackData;
	private Optional<String> switchInlineQuery;
	private Optional<String> switchInlineQueryCurrentChat;

	public InlineKeyboardButton(String text) {
		setText(text);
		url = Optional.empty();
		callbackData = Optional.empty();
		switchInlineQuery = Optional.empty();
		switchInlineQueryCurrentChat = Optional.empty();
	}

	public InlineKeyboardButton(String text, String callbackData) {
		this(text);
		setCallbackData(callbackData);
	}

	public static InlineKeyboardButton ofUrl(String text, String url) {
		InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton(text);
		inlineKeyboardButton.setUrl(url);
		return inlineKeyboardButton;
	}

	public static InlineKeyboardButton ofSwitchInlineQuery(String text, String switchInlineQuery) {
		InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton(text);
		inlineKeyboardButton.setSwitchInlineQuery(switchInlineQuery);
		return inlineKeyboardButton;
	}

	public String getText() { return text; }
	public void setText(String arg) { text = arg; }

	public Optional<String> getUrl() { return url; }
	public void setUrl(String arg) { url = Optional.of(arg); }

	public Optional<String> getCallbackData() { return callbackData; }
	public void setCallbackData(String arg) { callbackData = Optional.of(arg); }

	public Optional<String> getSwitchInlineQuery() { return switchInlineQuery; }
	public void setSwitchInlineQuery(String arg) { switchInlineQuery = Optional.of(arg); }

	public Optional<String> getSwitchInlineQueryCurrentChat() { return switchInlineQueryCurrentChat; }
	public void setSwitchInlineQueryCurrentChat(String arg) { switchInlineQueryCurrentChat = Optional.of(arg); }

	public String toString() {

		if (!url.isPresent() && !callbackData.isPresent() && !switchInlineQuery.isPresent() &&
			!switchInlineQueryCurrentChat.isPresent())
			throw new IllegalStateException("Can't create only text InlineKeyboardButton (is useless). You must specify or a url or callbackData or switchInlineMode etc.");
		StringBuilder sb = new StringBuilder("{\"text\": \"").append(text).append("\"");
		url.ifPresent(url -> {
			sb.append(", \"url\": \"").append(url).append("\"");
		});
		callbackData.ifPresent(callbackData -> {
			sb.append(", \"callback_data\": \"").append(callbackData).append("\"");
		});
		switchInlineQuery.ifPresent(switchInlineQuery -> {
			sb.append(", \"switch_inline_query\": \"").append(switchInlineQuery).append("\"");
		});
		switchInlineQueryCurrentChat.ifPresent(switchInlineQueryCurrentChat -> {
			sb.append(", \"switch_inline_query_current_chat\": \"").append(switchInlineQueryCurrentChat).append("\"");
		});
		sb.append("}");
		return sb.toString();
	}
}