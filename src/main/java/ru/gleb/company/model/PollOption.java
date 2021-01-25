package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PollOption extends Model {
	private String text;
	private int voterCount;

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "PollOption@{\n" +
	                repStr + "text: " + text + ",\n" +
	                repStr + "voterCount: " + voterCount + ",\n" +
	                repStr2 + "}";
	}
}
