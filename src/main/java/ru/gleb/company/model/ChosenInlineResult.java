package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChosenInlineResult extends Model {
	private String resultId;
	private User from;
	private String query;
	private Location location; // optional
	private String inlineMessageId; // optional

	public boolean hasLocation() {
		return location != null;
	}

	public boolean hasInlineMessageId() {
		return inlineMessageId != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "ChosenInlineResult@{\n" +
	                repStr + "resultId: " + resultId + ",\n" +
	                repStr + "from: " + from + ",\n" +
	                repStr + "location: " + (hasLocation() ? location.toString(repeat+1) : null) + ",\n" +
	                repStr + "inlineMessageId: " + inlineMessageId + ",\n" +
	                repStr + "query: " + query + ",\n" +
	                repStr2 + "}";
	}
}