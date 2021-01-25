package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoSize extends Model {
	private String fileId;
	private String fileUniqueId;
	private int width;
	private int height;
	private Integer fileSize; // optional

	public boolean hasFileSize() {
		return fileSize != null;
	}

	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "PhotoSize@{\n" +
	                repStr + "fileId: " + fileId + ",\n" +
	                repStr + "fileUniqueId: " + fileUniqueId + ",\n" +
	                repStr + "width: " + width + ",\n" +
	                repStr + "height: " + height + ",\n" +
	                repStr + "fileSize: " + fileSize + ",\n" +
	                repStr2 + "}";
	}	
}