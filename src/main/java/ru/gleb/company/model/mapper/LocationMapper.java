package ru.gleb.company.model.mapper;

import ru.gleb.company.model.Location;
import org.json.JSONObject;

public class LocationMapper {
	public static Location map(JSONObject obj) {
		if (obj == null)
			return null;

		Location location = new Location();
		location.setLongitude(obj.getDouble("longitude"));
		location.setLatitude(obj.getDouble("latitude"));
		location.setHorizontalAccuracy(obj.optDouble("horizontal_accuracy"));
		location.setLivePeriod(obj.optInt("live_period"));
		location.setHeading(obj.optInt("heading"));
		location.setProximityAlertRadius(obj.optInt("proximity_alert_radius"));
		
		return location;
	}
}