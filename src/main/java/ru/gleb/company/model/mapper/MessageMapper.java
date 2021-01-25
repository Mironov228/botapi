package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Message;
import ru.gleb.company.model.MessageEntity;
import org.json.JSONObject;
import org.json.JSONArray;

public class MessageMapper {
	public static Message map(JSONObject obj) {
		if (obj == null)
			return null;
		Message message = new Message();

		message.setMessageId(obj.getInt("message_id"));
		message.setDate(obj.getLong("date"));
		message.setFrom(UserMapper.map(obj.optJSONObject("from")));
		message.setSenderChat(ChatMapper.map(obj.optJSONObject("sender_chat")));
		message.setReplyToMessage(MessageMapper.map(obj.optJSONObject("reply_to_message")));
		message.setText(obj.optString("text"));
		message.setEntities(Mapper.mapArray(obj.optJSONArray("entities"),
			MessageEntityMapper::map, MessageEntity.class));
		message.setChat(ChatMapper.map(obj.optJSONObject("chat")));
		message.setForwardFrom(UserMapper.map(obj.optJSONObject("forward_from")));
		message.setForwardFromChat(ChatMapper.map(obj.optJSONObject("forward_from_chat")));
		message.setForwardFromMessageId(obj.optInt("forward_from_message_id"));
		message.setForwardSignature(obj.optString("forward_signature"));
		message.setForwardSenderName(obj.optString("forward_sender_name"));
		message.setEditDate(obj.optInt("edit_date"));
		message.setViaBot(UserMapper.map(obj.optJSONObject("via_bot")));
		message.setMediaGroupId(obj.optInt("media_group_id"));
		message.setAuthorSignature(obj.optString("author_signature"));
		message.setAudio(AudioMapper.map(obj.optJSONObject("audio")));
		message.setDocument(DocumentMapper.map(obj.optJSONObject("document")));
		message.setSticker(StickerMapper.map(obj.optJSONObject("sticker")));
		message.setVideo(VideoMapper.map(obj.optJSONObject("video")));
		message.setVoice(VoiceMapper.map(obj.optJSONObject("voice")));
		message.setCaption(obj.optString("caption"));
		message.setLocation(LocationMapper.map(obj.optJSONObject("location")));
		message.setPoll(PollMapper.map(obj.optJSONObject("poll")));	
		
		return message;
	}
}