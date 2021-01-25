package ru.gleb.company.model.keyboard;

import java.util.Optional;

public class ReplyKeyboardMarkup implements Keyboard {
	private KeyboardButton[][] keyboard;
	private Optional<Boolean> resizeKeyboard;
	private Optional<Boolean> oneTimeKeyboard;
	private Optional<Boolean> selective;

	public ReplyKeyboardMarkup(String[][] keyboard) {
		this(new KeyboardButton[1][1]);
		this.keyboard = new KeyboardButton[keyboard.length][];
		for (int i = 0; i < keyboard.length; i++) {
			KeyboardButton[] row = new KeyboardButton[keyboard[i].length];
			for (int j = 0; j < row.length; j++)
				row[j] = new KeyboardButton(keyboard[i][j]);
			this.keyboard[i] = row;
		}
	}

	public ReplyKeyboardMarkup(KeyboardButton[][] keyboard) {
		setKeyboard(keyboard);
		resizeKeyboard = Optional.empty();
		oneTimeKeyboard = Optional.empty();
		selective = Optional.empty();
	}

	public ReplyKeyboardMarkup(KeyboardButton[][] keyboard, boolean resizeKeyboard) {
		this(keyboard);
		setResizeKeyboard(resizeKeyboard);
	}

	public ReplyKeyboardMarkup(KeyboardButton[][] keyboard, boolean resizeKeyboard, boolean oneTimeKeyboard) {
		this(keyboard, resizeKeyboard);
		setOneTimeKeyboard(oneTimeKeyboard);
	}

	public KeyboardButton[][] getKeyboard() { return keyboard; }
	public void setKeyboard(KeyboardButton[][] arg) {
		keyboard = arg;
	}

	public Optional<Boolean> getResizeKeyboard() { return resizeKeyboard; }
	public void setResizeKeyboard(Boolean arg) { resizeKeyboard = Optional.of(arg); }

	public Optional<Boolean> getOneTimeKeyboard() { return oneTimeKeyboard; }
	public void setOneTimeKeyboard(Boolean arg) { oneTimeKeyboard = Optional.of(arg); }

	public Optional<Boolean> getSelective() { return selective; }
	public void setSelective(Boolean arg) { selective = Optional.of(arg); }

	@Override
	public String toJSON() {
		StringBuilder sb = new StringBuilder("{\"keyboard\": [");
		for (int i = 0; i < keyboard.length; i++) {
			sb.append("[");
			sb.append(keyboard[i][0]);
			System.out.println(keyboard[i][0]);
			for (int j = 1; j < keyboard[i].length; j++) {
				KeyboardButton btn = keyboard[i][j];
				if (btn != null)
					sb.append(", ").append(btn.toString());
			}
			sb.append("],");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		resizeKeyboard.ifPresent(resizeKeyboard -> {
			sb.append(", \"resize_keyboard\": ").append(resizeKeyboard);
		});
		oneTimeKeyboard.ifPresent(oneTimeKeyboard -> {
			sb.append(", \"one_time_keyboard\": ").append(oneTimeKeyboard);
		});
		selective.ifPresent(selective -> {
			sb.append(", \"selective\": ").append(selective);
		});
		sb.append("}");
		return sb.toString();
	}
}