package com.mmdev.ooplesson.service;

import com.mmdev.ooplesson.mapper.WordMapper;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public final class WordService {

	public static final WordService INSTANCE = new WordService();
	public static Scanner scanner = new Scanner(System.in);
	public static WordMapper wordMapper = WordMapper.getInstance();

	private WordService() {
	}

	public void choseLanguage() throws IOException {
		System.out.println("If you want to translate word from Russian into English press 0, \n" +
						   "from English into Russian press 1 ");
		int number = scanner.nextInt();
		if (number == 0) {
			fromRussianIntoEnglish();
		} else if (number == 1) {
			fromEnglishIntoRussian();
		}
	}

	private void fromEnglishIntoRussian() throws IOException {
		Map<String, String> stringMap = wordMapper.mapToWord();
		for (Map.Entry<String, String> englishWord : stringMap.entrySet()) {
			System.out.println(englishWord.getKey());
			String inputWord = scanner.next();
			scanner.nextLine();
			if (inputWord.equals(englishWord.getValue())) {
				System.out.println("correct answer");
			} else {
				System.err.println("wrong answer: correct is " + englishWord.getValue());
			}
		}
	}

	private void fromRussianIntoEnglish() throws IOException {
		Map<String, String> stringMap = wordMapper.mapToWord();
		for (Map.Entry<String, String> russianWord : stringMap.entrySet()) {
			System.out.println(russianWord.getValue());
			String inputWord = scanner.next();
			scanner.nextLine();
			if (inputWord.equals(russianWord.getKey())) {
				System.out.println("correct answer");
			} else {
				System.err.println("wrong answer: correct is " + russianWord.getKey());
			}
		}
	}

	public static WordService getInstance() {
		return INSTANCE;
	}
}
