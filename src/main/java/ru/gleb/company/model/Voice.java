package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Voice extends Model {
	private String fileId;
	private String fileUniqueId;
	private int duration;
	private String mimeType; // optional
	private Integer fileSize; // optional

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
        return "Voice@{\n" +
                repStr + "fileId: " + fileId + ",\n" +
                repStr + "fileUniqueId: " + fileUniqueId + ",\n" + 
                repStr + "duration: " + duration + ",\n" +
                repStr + "mimeType: " + mimeType + ",\n" +
                repStr + "fileSize: " + fileSize + ",\n" +
                repStr2 + "}";
	}
}
