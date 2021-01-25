package ru.gleb.company.model.mapper;

import ru.gleb.company.model.ChatPhoto;
import org.json.JSONObject;

public class ChatPhotoMapper {
	public static ChatPhoto map(JSONObject obj) {
		if (obj == null)
			return null;
		ChatPhoto chatPhoto = new ChatPhoto();

		chatPhoto.setSmallFileId(obj.getString("small_file_id"));
		chatPhoto.setSmallFileUniqueId(obj.getString("small_file_unique_id"));
		chatPhoto.setBigFileId(obj.getString("big_file_id"));
		chatPhoto.setBigFileUniqueId(obj.getString("big_file_unique_id"));

		return chatPhoto;
	}
}