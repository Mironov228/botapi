package ru.gleb.company.model.mapper;

import ru.gleb.company.model.ChatPermissions;
import org.json.JSONObject;

public class ChatPermissionsMapper {
	public static ChatPermissions map(JSONObject obj) {
		if (obj == null)
			return null;
		ChatPermissions chatPermissions = new ChatPermissions();

		chatPermissions.setCanSendMessages(obj.optBoolean("can_send_messages"));
		chatPermissions.setCanSendMediaMessages(obj.optBoolean("can_send_media_messages"));
		chatPermissions.setCanSendPolls(obj.optBoolean("can_send_polls"));
		chatPermissions.setCanSendOtherMessages(obj.optBoolean("can_send_other_messages"));
		chatPermissions.setCanAddWebPagePreviews(obj.optBoolean("can_send_add_web_page_previews"));
		chatPermissions.setCanChangeInfo(obj.optBoolean("can_change_info"));
		chatPermissions.setCanInviteUsers(obj.optBoolean("can_invite_users"));
		chatPermissions.setCanPinMessages(obj.optBoolean("can_pin_messages"));

		return chatPermissions;
	}
}