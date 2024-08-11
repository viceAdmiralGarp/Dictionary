package com.mmdev.ooplesson.language;

public enum Language {
	ENGLISH,
	RUSSIAN;

	public static Language fromNumber(int number) {
		return switch (number) {
			case 0 -> RUSSIAN;
			case 1 -> ENGLISH;
			default -> throw new IllegalArgumentException("Invalid number for Language: " + number);
		};
	}
}
