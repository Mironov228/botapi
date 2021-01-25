package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Sticker;
import org.json.JSONObject;

public class StickerMapper {
	public static Sticker map(JSONObject obj) {
		if (obj == null) return null;
		Sticker sticker = new Sticker();

		sticker.setFileId(obj.getString("file_id"));
		sticker.setFileUniqueId(obj.getString("file_unique_id"));
		sticker.setWidth(obj.getInt("width"));
		sticker.setHeight(obj.getInt("height"));
		sticker.setAnimated(obj.getBoolean("is_animated"));
		sticker.setThumb(PhotoSizeMapper.map(obj.optJSONObject("thumb")));
		sticker.setEmoji(obj.optString("emoji"));
		sticker.setSetName(obj.optString("set_name"));
		sticker.setMaskPosition(MaskPositionMapper.map(obj.optJSONObject("mask_position")));
		sticker.setFileSize(obj.optInt("file_size"));

		return sticker;
	}
}