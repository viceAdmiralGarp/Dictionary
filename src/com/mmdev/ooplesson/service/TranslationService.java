package com.mmdev.ooplesson.service;

import com.mmdev.ooplesson.mapper.WordMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class TranslationService {

	public static final TranslationService INSTANCE = new TranslationService();
	public static Scanner scanner = new Scanner(System.in);
	public static WordMapper wordMapper = WordMapper.getInstance();

	private TranslationService() {
	}

	public void choseLanguage() throws IOException {
		System.out.println("If you want to translate word from Russian into English press 0, \n" +
						   "from English into Russian press 1 ");
		int number = scanner.nextInt();
		scanner.nextLine();
		if (number == 0) {
			fromRuIntoEng();
		} else if (number == 1) {
			fromEngIntoRu();
		}
	}
	
	private void fromEngIntoRu() throws IOException {
		Map<String, String> randomSortedWords = wordMapper.initRandomSortedMap();
		Map<String, String> mistakes = checkAndHandleMistakesFromEngIntoRu(randomSortedWords);
		handleWrongRuWords(mistakes);
	}

	private void fromRuIntoEng() throws IOException {
		Map<String, String> randomSortedWords = wordMapper.initRandomSortedMap();
		Map<String, String> mistakes = checkAndHandleMistakesFromRuIntoEng(randomSortedWords);
		handleWrongEngWords(mistakes);
	}

	public Map<String, String> checkAndHandleMistakesFromEngIntoRu(Map<String, String> randomSortedWords) {
		Map<String, String> mistakes = new HashMap<>();
		for (Map.Entry<String, String> wordEntry : randomSortedWords.entrySet()) {
			System.out.println(wordEntry.getKey()); //display an English word (this word we need to translate into ru)
			String inputWord = scanner.nextLine();
			boolean isCorrectWord = isCorrectWord(inputWord, wordEntry.getValue());  //compare the entered word with ru word
			if (!isCorrectWord) {
				mistakes.put(wordEntry.getKey(), wordEntry.getValue());
			}
		}
		return mistakes;
	}

	public Map<String, String> checkAndHandleMistakesFromRuIntoEng(Map<String, String> randomSortedWords) {
		Map<String, String> mistakes = new HashMap<>();
		for (Map.Entry<String, String> wordEntry : randomSortedWords.entrySet()) {
			System.out.println(wordEntry.getValue()); //display an English word (this word we need to translate into ru)
			String inputWord = scanner.nextLine();
			boolean isCorrectWord = isCorrectWord(inputWord, wordEntry.getKey());  //compare the entered word with ru word
			if (!isCorrectWord) {
				mistakes.put(wordEntry.getKey(), wordEntry.getValue());
			}
		}
		return mistakes;
	}
	
	private void handleWrongEngWords(Map<String, String> wrongWords) {
		if (!wrongWords.isEmpty()) {
			int number = inputNumber();
			if (number == 0) {
				Map<String, String> mistakes = checkAndHandleMistakesFromRuIntoEng(wrongWords);
				if (!mistakes.isEmpty()) {
					handleWrongEngWords(mistakes);
				}
			}
		}
	}

	private void handleWrongRuWords(Map<String, String> wrongWords) {
		if (!wrongWords.isEmpty()) {
			int number = inputNumber();
			if (number == 0) {
				Map<String, String> mistakes = checkAndHandleMistakesFromEngIntoRu(wrongWords);
				if (!mistakes.isEmpty()) {
					handleWrongRuWords(mistakes);
				}
			}else {
				System.out.println("Ty for attempt");
			}
		}

	}
	
	private boolean isCorrectWord(String inputWord, String wordFromMap) {
		if (inputWord.equals(wordFromMap)) {
			System.out.println("correct answer");
			return true;
		}
		System.err.println("wrong answer: correct is " + wordFromMap);
		return false;
	}

	private int inputNumber() {
		System.out.println("You made a mistakes in some words, do you want to try write them correct? " +
						   "\n if yes press 0 , if no press 1");
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}

	public static TranslationService getInstance() {
		return INSTANCE;
	}
}