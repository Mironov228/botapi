package ru.gleb.company.model.keyboard;

public class InlineKeyboardMarkup implements Keyboard {
	private InlineKeyboardButton[][] inlineKeyboard;

	public InlineKeyboardMarkup(String[][] inlineKeyboard) {
		this.inlineKeyboard = new InlineKeyboardButton[inlineKeyboard.length][];
		for (int i = 0; i < inlineKeyboard.length; i++) {
			InlineKeyboardButton[] row = new InlineKeyboardButton[inlineKeyboard[i].length];
			for (int j = 0; j < row.length; j++) {
				row[j] = new InlineKeyboardButton(inlineKeyboard[i][j], inlineKeyboard[i][j]);
			}
			this.inlineKeyboard[i] = row;
		}
	}

	public InlineKeyboardMarkup(InlineKeyboardButton[][] inlineKeyboard) {
		this.inlineKeyboard = inlineKeyboard;
	}

	@Override
	public String toJSON() {
		StringBuilder sb = new StringBuilder("{\"inline_keyboard\": [");

		for (int i = 0; i < inlineKeyboard.length; i++) {
			sb.append("[");
			for (int j = 0; j < inlineKeyboard[i].length; j++) {
				sb.append(inlineKeyboard[i][j]).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("],");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]}");
		return sb.toString();
	}
}