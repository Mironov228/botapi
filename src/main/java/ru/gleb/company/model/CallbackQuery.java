package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CallbackQuery extends Model {
	private String id;
	private User from;
	private String chatInstance;
	private Message message; // optional
	private String inlineMessageId; // optional
	private String data; // optional
	private String gameShortName; // optional

	public boolean hasMessage() {
		return message != null;
	}

	public boolean hasInlineMessageId() {
		return inlineMessageId != null;
	}

	public boolean hasData() {
		return data != null;
	}

	public boolean hasGameShortName() {
		return gameShortName != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "CallbackQuery@{\n" +
	                repStr + "id: " + id + ",\n" +
	                repStr + "from: " + from.toString(repeat+1) + ",\n" +
	                repStr + "message: " + (hasMessage() ? message.toString(repeat + 1) : null) + ",\n" +
	                repStr + "inlineMessageId: " + inlineMessageId + ",\n" +
	                repStr + "chatInstance: " + chatInstance + ",\n" +
	                repStr + "data: " + data + ",\n" +
	                repStr + "gameShortName: " + gameShortName + "\n" +
	                repStr2 + "}";
	}
}
