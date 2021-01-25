package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Chat extends Model {
	private int id;
	private String type;
	private String title; // optional
	private String username; // optional
	private String firstName; // optional
	private String lastName; // optional
	private ChatPhoto photo; // optional. returned only in getChat
	private String bio; // optional. returned only in getChat
	private String description; // optional. returned only in getChat
	private String inviteLink; // optional. returned only in getChat
	private Message pinnedMessage; // optional. returned only in getChat
	private ChatPermissions permissions; // optional. returned only in getChat
	private Integer slowModeDelay; // optional. returned only in getChat
	private String stickerSetName; // optional. returned only in getChat
	private Boolean canSetStickerSet; // optional. returned only in getChat
	private Integer linkedChatId; // optional. returned only in getChat
	private ChatLocation location; // optional. returned only in getChat

	public boolean hasTitle() {
		return title != null;
	}

	public boolean hasUsername() {
		return username != null;
	}

	public boolean hasFirstName() {
		return firstName != null;
	}

	public boolean hasLastName() {
		return lastName != null;
	}

	public boolean hasPhoto() {
		return photo != null;
	}

	public boolean hasBio() {
		return bio != null;
	}

	public boolean hasDescription() {
		return description != null;
	}

	public boolean hasInviteLink() {
		return inviteLink != null;
	}

	public boolean hasPinnedMessage() {
		return pinnedMessage != null;
	}

	public boolean hasPermissions() {
		return permissions != null;
	}

	public boolean hasSlowModeDelay() {
		return slowModeDelay != null;
	}

	public boolean hasStickerSetName() {
		return stickerSetName != null;
	}

	public boolean hasCanSetStickerSet() {
		return canSetStickerSet != null;
	}

	public boolean hasLinkedChatId() {
		return linkedChatId != null;
	}

	public boolean hasLocation() {
		return location != null;
	}

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat-1);
		String repStr = repStr2+"\t";

		return "Chat@{\n" +
			repStr + "id: " + id + ",\n" +
			repStr + "type: " + type + ",\n" +
			repStr + "title: " + title + ",\n" +
			repStr + "username: " + username + ",\n" +
			repStr + "firstName: " + firstName + ",\n" +
			repStr + "lastName: " + lastName + ",\n" +
			repStr + "photo: " + (hasPhoto() ? photo.toString(repeat+1) : null) + ",\n" +
			repStr + "bio: " + bio + ",\n" +
			repStr + "description: " + description + ",\n" +
			repStr + "inviteLink: " + inviteLink + ",\n" +
			repStr + "pinnedMessage: " + (hasPinnedMessage() ? pinnedMessage.toString(repeat+1) : null) + ",\n" +
			repStr + "permissions: " + (hasPermissions() ? permissions.toString(repeat+1) : null) + ",\n" +
			repStr + "slowModeDelay: " + slowModeDelay + ",\n" +
			repStr + "stickerSetName: " + stickerSetName + ",\n" +
			repStr + "canSetStrickerSet: " + canSetStickerSet + ",\n" +
			repStr + "linkedChatId: " + linkedChatId + ",\n" +
			repStr + "location: " + (hasLocation() ? location.toString(repeat+1) : null) + ",\n" +
			repStr2 + "}";
	}
}