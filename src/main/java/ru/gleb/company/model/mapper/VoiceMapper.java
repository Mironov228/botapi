package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Voice;
import org.json.JSONObject;

public class VoiceMapper {
	public static Voice map(JSONObject obj) {
		if (obj == null) return null;
		Voice voice = new Voice();

		voice.setFileId(obj.getString("file_id"));
		voice.setFileUniqueId(obj.getString("file_unique_id"));
		voice.setDuration(obj.getInt("duration"));
		voice.setMimeType(obj.optString("mine_type"));
		voice.setFileSize(obj.optInt("file_size"));

		return voice;
	}
}