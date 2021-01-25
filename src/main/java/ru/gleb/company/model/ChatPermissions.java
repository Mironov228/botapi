package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatPermissions extends Model {
	private Boolean canSendMessages; // optional
	private Boolean canSendMediaMessages; // optional
	private Boolean canSendPolls; // optional
	private Boolean canSendOtherMessages; // optional
	private Boolean canAddWebPagePreviews; // optional
	private Boolean canChangeInfo; // optional
	private Boolean canInviteUsers; // optional
	private Boolean canPinMessages; // optional

	public boolean hasCanSendMessages() {
		return canSendMessages != null;
	}

	public boolean hasCanSendMediaMessages() {
		return canSendMediaMessages != null;
	}

	public boolean hasCanSendPolls() {
		return canSendPolls != null;
	}

	public boolean hasCanSendOtherMessages() {
		return canSendOtherMessages != null;
	}

	public boolean hasCanAddWebPagePreviews() {
		return canAddWebPagePreviews != null;
	}

	public boolean hasCanChangeInfo() {
		return canChangeInfo != null;
	}

	public boolean hasCanInviteUsers() {
		return canInviteUsers != null;
	}

	public boolean hasCanPinMessages() {
		return canPinMessages != null;
	}

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat-1);
		String repStr = repStr2+"\t";

		return "ChatPermissions@{\n" +
			repStr + "canSendMessages: " + canSendMessages + ",\n" +
			repStr + "canSendMediaMessages: " + canSendMediaMessages + ",\n" +
			repStr + "canSendPolls: " + canSendPolls + ",\n" +
			repStr + "canSendOtherMessages: " + canSendOtherMessages + ",\n" +
			repStr + "canAddWebPagePreviews: " + canAddWebPagePreviews + ",\n" +
			repStr + "canChangeInfo: " + canChangeInfo + ",\n" +
			repStr + "canInviteUsers: " + canInviteUsers + ",\n" +
			repStr + "canPinMessages: " + canPinMessages + ",\n" +
			repStr2 + "}";
	}
}