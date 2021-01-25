package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location extends Model {
	private double longitude;
	private double latitude;
	private Double horizontalAccuracy; // optional
	private Integer livePeriod; // optional
	private Integer heading; // optional
	private Integer proximityAlertRadius; // optional

	public boolean hasHorizontalAccuracy() {
		return horizontalAccuracy != null;
	}

	public boolean hasLivePeriod() {
		return livePeriod != null;
	}

	public boolean hasHeading() {
		return heading != null;
	}

	public boolean hasProximityAlertRadius() {
		return proximityAlertRadius != null;
	}

	@Override
	public String toString(int repeat) {
		String repStr2 = "\t".repeat(repeat-1);
		String repStr = repStr2 + "\t";
		return "Location@{" + 
			repStr + "longitude: " + longitude + ",\n" +
			repStr + "latitude: " + latitude + ",\n" +
			repStr + "horizontalAccuracy: " + horizontalAccuracy + ",\n" +
			repStr + "livePeriod: " + livePeriod + ",\n" +
			repStr + "heading: " + heading + ",\n" +
			repStr + "proximityAlertRadius: " + proximityAlertRadius + "\n" +
			repStr2 + "}";
	}
}