package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends Model {
	private int id;
	private boolean isBot;
	private String firstName;
	private String lastName; // optional
	private String username; // optional
	private String languageCode; // optional

	public boolean hasLastName() {
		return lastName != null;
	}

	public boolean hasUsername() {
		return username != null;
	}

	public boolean hasLanguageCode() {
		return languageCode != null;
	}

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat-1);
		String repStr = repStr2+"\t";

		return "User@{\n" +
			repStr + "id: " + id + ",\n" +
			repStr + "isBot: " + isBot + ",\n" +
			repStr + "firstName: " + firstName + ",\n" +
			repStr + "lastName: " + lastName + ",\n" +
			repStr + "username: " + username + ",\n" +
			repStr + "languageCode: " + languageCode + "\n" +
			repStr2 + "}";
	}
}