package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Message extends Model {
	private int messageId;
	private long date;
	private User from; // optional
	private Chat senderChat; // optional
	private Message replyToMessage; // optional
	private String text; // optional
	private MessageEntity[] entities; // optional
	private Chat chat; // optional
	private User forwardFrom; // optional
	private Chat forwardFromChat; // optional
	private Integer forwardFromMessageId; // optional
	private String forwardSignature; // optional
	private String forwardSenderName; // optional
	private Integer editDate; // optional
	private User viaBot; // optional
	private Integer mediaGroupId; // optional
	private String authorSignature; // optional
	private Audio audio; // optional
	private Document document; // optional
	private Sticker sticker; // optional
	private Video video; // optional
	private Voice voice; // optional
	private String caption; // optional
	private Location location; // optional
	private Poll poll; // optional

	public boolean hasFrom() { return from != null; }
	public boolean hasSenderChat() { return senderChat != null; }
	public boolean hasReplyToMessage() { return replyToMessage != null; }
	public boolean hasText() { return text != null; }
	public boolean hasEntities() { return entities != null; }
	public boolean hasChat() { return chat != null; }
	public boolean hasForwardFrom() { return forwardFrom != null; }
	public boolean hasForwardFromChat() { return forwardFromChat != null; }
	public boolean hasForwardFromMessageId() { return forwardFromMessageId != null; }
	public boolean hasForwardSignature() { return forwardSignature != null; }
	public boolean hasForwardSenderName() { return forwardSenderName != null; }
	public boolean hasEditDate() { return editDate != null; }
	public boolean hasViaBot() { return viaBot != null; }
	public boolean hasMediaGroupId() { return mediaGroupId != null; }
	public boolean hasAuthorSignature() { return authorSignature != null; }
	public boolean hasAudio() { return audio != null; }
	public boolean hasDocument() { return document != null; }
	public boolean hasSticker() { return sticker != null; }
	public boolean hasVideo() { return video != null; }
	public boolean hasVoice() { return voice != null; }
	public boolean hasCaption() { return caption != null; }
	public boolean hasLocation() { return location != null; }
	public boolean hasPoll() { return poll != null; }

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        String entitiesString = hasEntities() ?
	        	"[\n" + Arrays.stream(entities).collect(StringBuilder::new,
	        		(a, b) -> a.append(b.toString(repeat+2)).append(",\n"), StringBuilder::append)
	        	.append(repStr).append("]").toString()
	        	: null;
	        return "Message@{\n" +
	                repStr + "messageId: " + messageId + ",\n" +
	                repStr + "date: " + date + ",\n" +
	                repStr + "from: " + (hasFrom() ? from.toString(repeat+1) : null) + ",\n" +
	                repStr + "senderChat: " + (hasSenderChat() ? senderChat.toString(repeat+1) : null) + ",\n" +
	                repStr + "replyToMessage: " + (hasReplyToMessage() ? replyToMessage.toString(repeat+1) : null) + ",\n" +
	                repStr + "text: " + text + ",\n" +
	                repStr + "entities: " + entitiesString + ",\n" +
	                repStr + "chat: " + (hasChat() ? chat.toString(repeat+1) : null) + ",\n" +
	                repStr + "forwardFrom: " + (hasForwardFrom() ? forwardFrom.toString(repeat+1) : null) + ",\n" +
	                repStr + "forwardFromChat: " + (hasForwardFromChat() ? forwardFromChat.toString(repeat+1) : null) + ",\n" +
	                repStr + "forwardFromMessageId: " + forwardFromMessageId + ",\n" +
	                repStr + "forwardSignature: " + forwardSignature + ",\n" +
	                repStr + "forwardSenderName: " + forwardSenderName + ",\n" +
	                repStr + "editDate: " + editDate + ",\n" +
	                repStr + "viaBot: " + (hasViaBot() ? viaBot.toString(repeat+1) : null) + ",\n" +
	                repStr + "mediaGroupId: " + mediaGroupId + ",\n" +
	                repStr + "authorSignature: " + authorSignature + ",\n" +
	                repStr + "audio: " + (hasAudio() ? audio.toString(repeat+1) : null) + ",\n"	 +
	                repStr + "document: " + (hasDocument() ? document.toString(repeat+1) : null) + ",\n" +
	                repStr + "sticker: " + (hasSticker() ? sticker.toString(repeat+1) : null) + ",\n" +
	                repStr + "video: " + (hasVideo() ? video.toString(repeat+1) : null) + ",\n" +
	                repStr + "voice: " + (hasVoice() ? voice.toString(repeat+1) : null) + ",\n" +
	                repStr + "caption: " + caption + ",\n" +
	                repStr + "location: " + (hasLocation() ? location.toString(repeat+1) : null) + ",\n" +
	                repStr + "poll: " + (hasPoll() ? poll.toString(repeat+1) : null) + "\n" +
	                repStr2 + "}";
	}

}