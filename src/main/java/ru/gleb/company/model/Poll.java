package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Poll extends Model {
	private String id;
	private String question;
	private PollOption[] options;
	private int totalVoterCount;
	private boolean isClosed;
	private boolean isAnonymous;
	private String type;
	private boolean allowsMultipleAnswers;
	private Integer correctOptionId; // optional
	private String explanation; // optional
	private MessageEntity[] explanationEntities; // optional
	private Integer openPeriod; // optional
	private Integer closeDate; // optional

	public boolean hasCorrectOptionId() { return correctOptionId != null; }
	public boolean hasExplanation() { return explanation != null; }
	public boolean hasExplanationEntities() { return explanationEntities != null; }
	public boolean hasOpenPeriod() { return openPeriod != null; }
	public boolean hasCloseDate() { return closeDate != null; }

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "Poll@{\n" +
	                repStr + "id: " + id + ",\n" +
	                repStr + "question: " + question + ",\n" +
	                repStr + "options: [\n" + Arrays.stream(options).collect(StringBuilder::new,
						(a, b) -> a.append(repStr).append("\t").append(b.toString(repeat+2)).append(",\n"),
						StringBuilder::append).append(repStr).append("],\n") +
	                repStr + "totalVoterCount: " + totalVoterCount + ",\n" +
	                repStr + "isClosed: " + isClosed + ",\n" +
	                repStr + "isAnonymous: " + isAnonymous + ",\n" +
	                repStr + "type: " + type + ",\n" +
	                repStr + "allowsMultipleAnswers: " + allowsMultipleAnswers + ",\n" +
	                repStr + "correctOptionId: " + correctOptionId + ",\n" +
	                repStr + "explanation: " + explanation + ",\n" +
	                repStr + "explanationEntities: " + "[\n" + (hasExplanationEntities() ?
						Arrays.stream(explanationEntities).map(el -> el.toString(repeat+2)).collect(
								StringBuilder::new, (a, b) -> a.append(b).append(",\n"),
								StringBuilder::append) : null) + "],\n" +
	                repStr + "openPeriod: " + openPeriod + ",\n" +
	                repStr + "closeDate: " + closeDate + ",\n" +
	                repStr2 + "}";
	}
}