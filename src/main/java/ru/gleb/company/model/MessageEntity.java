package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageEntity extends Model {
	private String type;
	private int offset;
	private int length;

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat-1);
		String repStr = repStr2+"\t";

		return repStr2 + "MessageEntity@{\n" +
			repStr + "type: " + type + ",\n" +
			repStr + "offset: " + offset + ",\n" +
			repStr + "length: " + length + "\n" +
			repStr2 + "}";
	}
}