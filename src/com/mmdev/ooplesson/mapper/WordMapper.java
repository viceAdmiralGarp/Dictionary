package com.mmdev.ooplesson.mapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public final class WordMapper {

	private final static int START_OF_THE_STRING = 0;
	private final static Path PATH = Path.of("resources", "words.txt");
	public static final String SEPARATOR = "=";
	private final BufferedReader reader = new BufferedReader(new FileReader(PATH.toFile()));
	public static WordMapper INSTANCE;

	static {
		try {
			INSTANCE = new WordMapper();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private WordMapper() throws FileNotFoundException {
	}

	public Map<String, String> parseLinesToMap() throws IOException {
		Map<String, String> words = new HashMap<>();
		while (reader.read() != -1) {
			StringBuilder line = new StringBuilder(reader.readLine());
			int indexOfSpace = line.indexOf(SEPARATOR);
			if (indexOfSpace == -1) {
				break;
			}
			words.put(line.substring(START_OF_THE_STRING, indexOfSpace)
					, line.substring(indexOfSpace + 1, line.length()));
		}
		return words;
	}

	public Map<String, String> shuffleMap(Map<String, String> map) {
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.shuffle(keys);
		Comparator<String> randomComparator = Comparator.comparingInt(keys::indexOf);
		Map<String, String> sortedMap = new TreeMap<>(randomComparator);
		for (String key : keys) {
			sortedMap.put(key, map.get(key));
		}
		return sortedMap;
	}

	public Map<String, String> createShuffledMap() throws IOException {
		return shuffleMap(parseLinesToMap());
	}

	public static WordMapper getInstance() {
		return INSTANCE;
	}
}
