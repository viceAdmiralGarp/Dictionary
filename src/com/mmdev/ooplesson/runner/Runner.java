package com.mmdev.ooplesson.runner;

import com.mmdev.ooplesson.service.TranslationService;

import java.io.IOException;


public class Runner {
	public static void main(String[] args) throws IOException {
		TranslationService translationService = TranslationService.getInstance();
		translationService.choseLanguage();
	}
}




































