package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatPhoto extends Model {
	private String smallFileId;
	private String smallFileUniqueId;
	private String bigFileId;
	private String bigFileUniqueId;

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat+1);
		String repStr = repStr2 + "\t";
		return "ChatPhoto@{\n" +
			repStr + "smallFileId: " + smallFileId + ",\n" +
			repStr + "smallFileUniqueId: " + smallFileUniqueId + ",\n" +
			repStr + "bigFileId: " + bigFileId + ",\n" + 
			repStr + "bigFileUniqueId: " + bigFileId + "\n" +
			repStr2 + "}";
	}
}