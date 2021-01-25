package ru.gleb.company.model.mapper;

import ru.gleb.company.model.MaskPosition;
import org.json.JSONObject;

public class MaskPositionMapper {
	public static MaskPosition map(JSONObject obj) {
		if (obj == null) return null;
		MaskPosition maskPos = new MaskPosition();

		maskPos.setPoint(obj.getString("point"));
		maskPos.setXShift(obj.getDouble("x_shift"));
		maskPos.setYShift(obj.getDouble("y_shift"));
		maskPos.setScale(obj.getDouble("scale"));

		return maskPos;
	}
}