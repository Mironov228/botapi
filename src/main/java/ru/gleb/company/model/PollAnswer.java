package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@Setter
public class PollAnswer extends Model {
	private String pollId;
	private User user;
	private int[] optionIds;	

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "PollAnswer@{\n" +
	                repStr + "pollId: " + pollId + ",\n" +
	                repStr + "user: " + user + ",\n" +
	                repStr + "optionIds: " + Arrays.toString(optionIds) + ",\n" +
	                repStr2 + "}";
	}
}