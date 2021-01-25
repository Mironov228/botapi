package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Update extends Model {
	private Integer updateId;
	private Message message; // optional
	private Message editedMessage; // optional
	private Message channelPost; // optional
	private Message editedChannelPost; // optional
	private InlineQuery inlineQuery; // optional
	private ChosenInlineResult chosenInlineResult; // optional
	private CallbackQuery callbackQuery; // optional
	private ShippingQuery shippingQuery; // optional
	private PreCheckoutQuery preCheckoutQuery; // optional
	private PollAnswer pollAnswer; // optional

	public boolean hasMessage() { return message != null; }
	public boolean hasEditedMessage() { return editedMessage != null; }
	public boolean hasChannelPost() { return channelPost != null; }
	public boolean hasEditedChannelPost() { return editedChannelPost != null; }
	public boolean hasInlineQuery() { return inlineQuery != null; }
	public boolean hasChosenInlineResult() { return chosenInlineResult != null; }
	public boolean hasCallbackQuery() { return callbackQuery != null; }
	public boolean hasShippingQuery() { return shippingQuery != null; }
	public boolean hasPreCheckoutQuery() { return preCheckoutQuery != null; }
	public boolean hasPollAnswer() { return pollAnswer != null; }

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "Update@{\n" +
	                repStr + "updateId: " + updateId + ",\n" +
	                repStr + "message: " + (hasMessage() ? message.toString(repeat+1) : null) + ",\n" +
	                repStr + "editedMessage: " + (hasEditedMessage() ? editedMessage.toString(repeat+1) : null) + ",\n" +
	                repStr + "channelPost: " + (hasChannelPost() ? channelPost.toString(repeat+1) : null) + ",\n" +
	                repStr + "editedChannelPost: " + (hasEditedChannelPost() ? editedChannelPost.toString(repeat+1) : null) + ",\n" +
	                repStr + "inlineQuery: " + (hasInlineQuery() ? inlineQuery.toString(repeat+1) : null) + ",\n" +
	                repStr + "chosenInlineResult: " + (hasChosenInlineResult() ? chosenInlineResult.toString(repeat+1) : null) + ",\n" +
	                repStr + "callbackQuery: " + (hasCallbackQuery() ? callbackQuery.toString(repeat+1) : null) + ",\n" +
	                repStr + "shippingQuery: " + (hasShippingQuery() ? shippingQuery.toString(repeat+1) : null) + ",\n" +
	                repStr + "preCheckoutQuery: " + (hasPreCheckoutQuery() ? preCheckoutQuery.toString(repeat+1) : null) + ",\n" +
	                repStr + "pollAnswer: " + (hasPollAnswer() ? pollAnswer.toString(repeat+1) : null) + ",\n" +
	                repStr2 + "}";
	}
}