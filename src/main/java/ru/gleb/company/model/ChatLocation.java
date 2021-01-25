package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatLocation extends Model {
	private Location location;
	private String address;

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat-1);
		String repStr = repStr2 + "\t";
		return "ChatLocation@{" + 
			repStr + "location: " + location.toString(repeat+1) + ",\n" +
			repStr + "address: " + address + "\n" +
			repStr2 + "}";
	}
}