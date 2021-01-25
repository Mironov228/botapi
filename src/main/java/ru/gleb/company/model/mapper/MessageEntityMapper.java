package ru.gleb.company.model.mapper;

import org.json.JSONObject;
import ru.gleb.company.model.MessageEntity;

public class MessageEntityMapper {
	public static MessageEntity map(JSONObject obj) {
		if (obj == null)
			return null;
		
		MessageEntity messageEntity = new MessageEntity();

		messageEntity.setType(obj.getString("type"));
		messageEntity.setOffset(obj.getInt("offset"));
		messageEntity.setLength(obj.getInt("length"));

		return messageEntity;
	}
}