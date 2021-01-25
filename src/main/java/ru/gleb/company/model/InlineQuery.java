package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InlineQuery extends Model {
	private String id;
	private User from;
	private String query;
	private String offset;
	private Location location; // optional

	public boolean hasLocation() {
		return location != null;
	}

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "InlineQuery@{\n" +
	                repStr + "id: " + id + ",\n" +
	                repStr + "from: " + from + ",\n" +
	                repStr + "location: " + (hasLocation() ? location.toString(repeat+1) : null) + ",\n" +
	                repStr + "query: " + query + ",\n" +
	                repStr + "offset: " + offset + "\n" +
	                repStr2 + "}";
	}
}