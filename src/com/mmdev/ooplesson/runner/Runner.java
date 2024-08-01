package com.mmdev.ooplesson.runner;

import com.mmdev.ooplesson.service.TranslationService;

import java.io.IOException;


public class Runner {
	public static void main(String[] args) throws IOException {
		TranslationService translationService = TranslationService.getInstance();
		translationService.choseLanguage();
	}
}





































//		Path path = Path.of("resources", "res.txt");
//		List<StringBuilder> list = new ArrayList<>();
//		try (Scanner scanner = new Scanner(path)) {
//			String currentStr = null;
//			while (scanner.hasNext()) {
//				currentStr = scanner.next();
//				StringBuilder stringBuilder = new StringBuilder();
//				for (int i = 0; i < currentStr.length() - 1; i++) {
//					if ((checkNumber(currentStr.charAt(i)) && checkNumber(currentStr.charAt(i + 1)))
//						|| checkNumber(currentStr.charAt(i))) {
//						stringBuilder.append(currentStr.charAt(i));
//					}
//				}
//				if (checkNumber(currentStr.charAt(currentStr.length() - 1))) {
//					stringBuilder.append(currentStr.charAt(currentStr.length() - 1));
//				}
//				list.add(stringBuilder);
//			}
//		}
//		list.stream()
//	}
//
//
//	private static boolean checkNumber(char c) {
//		return c == '1' ||
//			   c == '2' ||
//			   c == '3' ||
//			   c == '4' ||
//			   c == '5' ||
//			   c == '6' ||
//			   c == '7' ||
//			   c == '8' ||
//			   c == '9' ||
//			   c == '0';
//	}


