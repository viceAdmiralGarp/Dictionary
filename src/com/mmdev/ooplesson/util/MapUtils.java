package com.mmdev.ooplesson.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	private MapUtils() {
		throw new UnsupportedOperationException("Utility class should not be instantiated");
	}

	public static Map<String, String> swapKeysAndValues(Map<String, String> originalMap) {
		Map<String, String> swappedMap = new HashMap<>();
		for (Map.Entry<String, String> entry : originalMap.entrySet()) {
			swappedMap.put(entry.getValue(), entry.getKey());
		}
		return swappedMap;
	}
}
