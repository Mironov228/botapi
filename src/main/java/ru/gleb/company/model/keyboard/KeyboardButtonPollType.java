package ru.gleb.company.model.keyboard;

public class KeyboardButtonPollType {
	private String type;

	public KeyboardButtonPollType(String type) {
		this.type = type;
	}

	public String toString() {
		return "{\"type\": \"" + type + "\"}";
	}
}