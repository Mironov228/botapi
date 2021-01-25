package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Video;
import org.json.JSONObject;

public class VideoMapper {
	public static Video map(JSONObject obj) {
		if (obj == null) return null;
		Video video = new Video();

		video.setFileId(obj.getString("file_id"));
		video.setFileId(obj.getString("file_unique_id"));
		video.setWidth(obj.getInt("width"));
		video.setHeight(obj.getInt("height"));
		video.setDuration(obj.getInt("duration"));
		video.setThumb(PhotoSizeMapper.map(obj.optJSONObject("thumb")));
		video.setFileName(obj.optString("file_name"));
		video.setMimeType(obj.optString("mime_type"));
		video.setFileSize(obj.optInt("file_size"));

		return video;
	}
}