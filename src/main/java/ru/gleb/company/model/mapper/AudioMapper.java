package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Audio;
import org.json.JSONObject;

public class AudioMapper {
	public static Audio map(JSONObject obj) {
		if (obj == null) return null;

		Audio audio = new Audio();

		audio.setFileId(obj.getString("file_id"));
		audio.setFileUniqueId(obj.getString("file_unique_id"));
		audio.setDuration(obj.getInt("duration"));
		audio.setPerformer(obj.optString("performer"));
		audio.setTitle(obj.optString("title"));
		audio.setFileName(obj.optString("file_name"));
		audio.setMimeType(obj.optString("mime_type"));
		audio.setFileSize(obj.optInt("file_size"));
		audio.setThumb(PhotoSizeMapper.map(obj.optJSONObject("thumb")));

		return audio;
	}
}