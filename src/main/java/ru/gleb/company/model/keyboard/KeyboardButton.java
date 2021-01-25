package ru.gleb.company.model.keyboard;

import java.util.Optional;

public class KeyboardButton {
	private String text;
	private Optional<Boolean> requestContact;
	private Optional<Boolean> requestLocation;
	private Optional<KeyboardButtonPollType> requestPoll;

	public KeyboardButton(String text) {
		this.text = text;
		requestContact = Optional.empty();
		requestLocation = Optional.empty();
		requestPoll = Optional.empty();
	}

	public KeyboardButton(String text, boolean requestLocation) {
		this(text);
		setRequestLocation(requestLocation);
	}

	public KeyboardButton(String text, boolean requestLocation, boolean requestContact) {
		this(text);
		setRequestLocation(requestLocation);
		setRequestContact(requestContact);
	}
	
	public KeyboardButton(String text, KeyboardButtonPollType requestPoll) {
		this(text);
		setRequestPoll(requestPoll);
	}

	public String getText() { return text; }
	public void setText(String arg) { text = arg; }

	public Optional<Boolean> getRequestContact() { return requestContact; }
	public void setRequestContact(Boolean arg) { requestContact = Optional.of(arg); }

	public Optional<Boolean> getRequestLocation() { return requestLocation; }
	public void setRequestLocation(Boolean arg) { requestLocation = Optional.of(arg); }

	public Optional<KeyboardButtonPollType> getRequestPoll() { return requestPoll; }
	public void setRequestPoll(KeyboardButtonPollType arg) { requestPoll = Optional.of(arg); }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{\"text\": \"");
		sb.append(text).append("\"");
		requestContact.ifPresent(requestContact -> {
			sb.append(", \"request_contact\": ").append(requestContact);
		});
		requestLocation.ifPresent(requestLocation -> {
			sb.append(", \"request_location\": ").append(requestLocation);
		});
		requestPoll.ifPresent(requestPoll -> {
			sb.append(", \"request_poll\": ").append(requestPoll);
		});
		sb.append("}");
		return sb.toString();
	}
}