package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Document extends Model {
	private String fileId;
	private String fileUniqueId;
	private PhotoSize thumb; // optional
	private String fileName; // optional
	private String mimeType; // optional
	private Integer fileSize; // optional

	public boolean hasThumb() {
		return thumb != null;
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

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "Document@{\n" +
	                repStr + "fileId: " + fileId + ",\n" +
	                repStr + "fileUniqueId: " + fileUniqueId + ",\n" +
	                repStr + "thumb: " + (hasThumb() ? thumb.toString(repeat+1) : null) + ",\n" +
	                repStr + "fileName: " + fileName + ",\n" +
	                repStr + "mimeType: " + mimeType + ",\n" +
	                repStr + "fileSize: " + fileSize + ",\n" +
	                repStr2 + "}";
	}
} 