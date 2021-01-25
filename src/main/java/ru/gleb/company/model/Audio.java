package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Audio extends Model {
	private String fileId;
	private String fileUniqueId;
	private Integer duration;
	private String performer; // optional
	private String title; // optional
	private String fileName; // optional
	private String mimeType; // optional
	private Integer fileSize; // optional
	private PhotoSize thumb; // optional

	public boolean hasPerformer() {
		return performer != null;
	}
	public boolean hasTitle() {
		return title != null;
	}

	public boolean hasFileName() {
		return fileName != null;
	}

	public boolean hasMimeType() {
		return mimeType != null;
	}

	public boolean hasFileSize() {
		return fileSize != null;
	}

	public boolean hasThumb() {
		return thumb != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "Audio@{\n" +
	                repStr + "fileId: " + fileId + ",\n" +
	                repStr + "fileUniqueId: " + fileUniqueId + ",\n" +
	                repStr + "duration: " + duration + ",\n" +
	                repStr + "performer: " + performer + ",\n" +
	                repStr + "title: " + title + ",\n" +
	                repStr + "fileName: " + fileName + ",\n" +
	                repStr + "mimeType: " + mimeType + ",\n" +
	                repStr + "fileSize: " + fileSize + ",\n" +
	                repStr + "thumb: " + (hasThumb() ? thumb.toString(repeat+1) : null) + ",\n" +
	                repStr2 + "}";
	}
}