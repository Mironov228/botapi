package ru.gleb.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaskPosition extends Model {
	private String point;
	private double xShift;
	private double yShift;
	private double scale;

	@Override
	public String toString(int repeat) {
	        String repStr2 = "\t".repeat(repeat-1);
	        String repStr = repStr2 + "\t";
	        return "MaskPosition@{\n" +
	                repStr + "point: " + point + ",\n" +
	                repStr + "xShift: " + xShift + ",\n" +
	                repStr + "yShift: " + yShift + ",\n" +
	                repStr + "scale: " + scale + "\n" +
	                repStr2 + "}";
	}	
}