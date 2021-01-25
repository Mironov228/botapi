package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Chat;
import org.json.JSONObject;

public class ChatMapper {
	public static Chat map(JSONObject obj) {
		if (obj == null)
			return null;
		Chat chat = new Chat();

		chat.setId(obj.getInt("id"));
		chat.setType(obj.getString("type"));
		chat.setTitle(obj.optString("title"));
		chat.setUsername(obj.optString("username"));
		chat.setFirstName(obj.optString("first_name"));
		chat.setLastName(obj.optString("last_name"));
		chat.setPhoto(ChatPhotoMapper.map(obj.optJSONObject("photo")));
		chat.setBio(obj.optString("bio"));
		chat.setDescription(obj.optString("description"));
		chat.setInviteLink(obj.optString("invite_link"));
		chat.setPinnedMessage(MessageMapper.map(obj.optJSONObject("pinned_message")));
		chat.setPermissions(ChatPermissionsMapper.map(obj.optJSONObject("permissions")));
		chat.setSlowModeDelay(obj.optInt("slow_mode_delay"));
		chat.setStickerSetName(obj.optString("sticker_set_name"));
		chat.setCanSetStickerSet(obj.optBoolean("can_set_sticker_set"));
		chat.setLinkedChatId(obj.optInt("linked_chat_id"));
		chat.setLocation(ChatLocationMapper.map(obj.optJSONObject("location")));
		
		return chat;
	}
}