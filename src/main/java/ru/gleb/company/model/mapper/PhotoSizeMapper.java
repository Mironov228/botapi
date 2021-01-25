package ru.gleb.company.model.mapper;

import ru.gleb.company.model.PhotoSize;
import org.json.JSONObject;

public class PhotoSizeMapper {
	public static PhotoSize map(JSONObject obj) {
		if (obj == null) return null;
		PhotoSize photoSize = new PhotoSize();

		photoSize.setFileId(obj.getString("file_id"));
		photoSize.setFileUniqueId(obj.getString("file_unique_id"));
		photoSize.setWidth(obj.getInt("width"));
		photoSize.setHeight(obj.getInt("height"));
		photoSize.setFileSize(obj.optInt("file_size"));

		return photoSize;
	}
}