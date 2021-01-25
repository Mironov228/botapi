package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Document;
import org.json.JSONObject;

public class DocumentMapper {
	public static Document map(JSONObject obj) {
		if (obj == null) return null;
		Document document = new Document();

		document.setFileId(obj.getString("file_id"));
		document.setFileUniqueId(obj.getString("file_unique_id"));
		document.setThumb(PhotoSizeMapper.map(obj.optJSONObject("thumb")));
		document.setFileName(obj.optString("file_name"));
		document.setMimeType(obj.optString("mime_type"));
		document.setFileSize(obj.optInt("file_size"));

		return document;
	}
}