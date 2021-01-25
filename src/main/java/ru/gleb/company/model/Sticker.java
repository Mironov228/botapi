package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sticker extends Model {
	private String fileId;
	private String fileUniqueId;
	private int width;
	private int height;
	private boolean isAnimated;
	private PhotoSize thumb; // optional
	private String emoji; // optional
	private String setName; // optional
	private MaskPosition maskPosition; // optional
	private Integer fileSize; // optional

	public boolean hasThumb() {
		return thumb != null;
	}

	public boolean hasEmoji() {
		return emoji != null;
	}

	public boolean hasSetName() {
		return setName != null;
	}

	public boolean hasMaskPosition() {
		return maskPosition != null;
	}

	public boolean hasFileSize() {
		return fileSize != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "Sticker@{\n" +
	                repStr + "fileId: " + fileId + ",\n" +
	                repStr + "fileUniqueId: " + fileUniqueId + ",\n" +
	                repStr + "width: " + width + ",\n" +
	                repStr + "height: " + height + ",\n" +
	                repStr + "isAnimated: " + isAnimated + ",\n" +
	                repStr + "thumb: " + (hasThumb() ? thumb.toString(repeat+1) : null) + ",\n" +
	                repStr + "emoji: " + emoji + ",\n" +
	                repStr + "setName: " + setName + ",\n" +
	                repStr + "maskPosition: " + (hasMaskPosition() ? maskPosition.toString(repeat+1) : null) + ",\n" +
	                repStr + "fileSize: " + fileSize + ",\n" +
	                repStr2 + "}";
	}
}