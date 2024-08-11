package com.mmdev.ooplesson.language;

public enum Language {
	ENGLISH,
	RUSSIAN;

	public static Language fromNumber(int number) {
		switch (number) {
			case 0:
				return RUSSIAN;
			case 1:
				return ENGLISH;
			default:
				throw new IllegalArgumentException("Invalid number for Language: " + number);
		}
	}
}
