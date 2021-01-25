package ru.gleb.company.model.mapper;

import ru.gleb.company.model.ChatLocation;
import org.json.JSONObject;

public class ChatLocationMapper {
	public static ChatLocation map(JSONObject obj) {
		if (obj == null)
			return null;
		ChatLocation chatLocation = new ChatLocation();

		chatLocation.setLocation(LocationMapper.map(obj.getJSONObject("location")));
		chatLocation.setAddress(obj.getString("address"));

		return chatLocation;
	}
}