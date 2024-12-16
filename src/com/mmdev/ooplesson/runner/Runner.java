package com.mmdev.ooplesson.runner;

import com.mmdev.ooplesson.service.TranslationService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Create analog the service: <a href="

 ">Example</a>
 *
 * Notes:
 * Maybe a problem:
 * - hash-function collision
 * - execution in a distributed system
 */
public class Runner {

	public static void main(String[] args) throws IOException {
		TranslationService translationService = TranslationService.getInstance();
		translationService.choseLanguage();
	}

//	private static final String POSSIBLE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzAbCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//	private static final String TINY_URL_HOST = "https://tinyurl.com/";
//
//	private static String LONG_URL_2 = "https://javarush.com/";
//	private static String LONG_URL_1 = "https://gist.github.com/";
//
//	// We will don't use BD, we will use more simply variant with Map.
//	private static Map<String, String> longUrlToShort = new HashMap<>();
//	private static Map<String, String> shortUrlToLong = new HashMap<>();
//
//	public static String encode(String longUrl) {
//		int hash = hash(longUrl);
//		if (longUrlToShort.containsKey(longUrl)) {
//			return longUrlToShort.get(longUrl);
//		}
//		longUrlToShort.put(longUrl, TINY_URL_HOST + hash);
//		return longUrlToShort.get(longUrl);
//	}
//
//	public static String decode(String shortUrl) {
//		int hash = hash(shortUrl);
//		if (shortUrlToLong.containsKey(shortUrl)) {
//			return shortUrlToLong.get(shortUrl);
//		}
//		shortUrlToLong.put(shortUrl, shortUrl + hash);
//		return shortUrlToLong.get(shortUrl);
//	}
//
//	private static int hash(String longUrl) {
//		return Objects.hash(longUrl);
//	}
//
//	public static void main(String[] args) {
//
//
//		String actualShort = encode(LONG_URL_1);
//		String actualLong = decode(actualShort);
//		String expected = LONG_URL_1;
//		System.out.println("Long URL: " + LONG_URL_1 + " , short URL: " + actualShort);
//	}






//	public String encode(String longUrl) {
//		String s = randomStr(5);
//		if (longUrlToShort.containsKey(s)) {
//			return longUrlToShort.get(s);
//		}
//		longUrlToShort.put(longUrl.hashCode(), TINY_URL_HOST);
//
//		return longUrlToShort.get(longUrl.hashCode());
//	}
//
//	public String randomStr(int value) {
//		StringBuilder stringBuilder = new StringBuilder();
//		Random random = new Random();
//		for (int i = 0; i < value; i++) {
//			stringBuilder.append(POSSIBLE_SYMBOLS.charAt(random.nextInt(0, POSSIBLE_SYMBOLS.length() - 1)));
//		}
//		return stringBuilder.toString();
//	}


}



//--------------------------------
//Solution
//--------------------------------
///**
// * Create analog the service: <a href="
//
// ">Example</a>
// *
// * Notes:
// * Maybe a problem:
// * - hash-function collision
// * - execution in a distributed system
// */
//public class ShortUrlMaker {
//	private static final String POSSIBLE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzAbCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//	private static final String TINY_URL_HOST = "
//
//";
//	private static String LONG_URL_1 = "
//
//";
//
//	// We will don't use BD, we will use more simply variant with Map.
//	private static Map<String, String> longUrlToShort = new HashMap<>();
//	private static Map<String, String> shortUrlToLong = new HashMap<>();
//
//	public String encode(String longUrl) {
//// Check key
//		if (longUrlToShort.containsKey(longUrl)) {
//			return longUrlToShort.get(longUrl);
//		}
//
//		String encoded = TINY_URL_HOST + hash();
//		longUrlToSh
//		ort.put(longUrl, encoded);
//		shortUrlToLong.put(encoded, longUrl);
//
//		return encoded;
//	}
//
//	private String hash() {
//		StringBuilder hashBuilder = new StringBuilder();
//		Random random = new Random();
//		while (true) {
//			for (int i = 0; i < 7; i++) {
//				hashBuilder.append(random.nextInt(POSSIBLE_SYMBOLS.length()));
//			}
//			if (!shortUrlToLong.containsKey(hashBuilder.toString())) {
//				return hashBuilder.toString();
//			}
//			hashBuilder.setLength(0);
//		}
//	}
//
//	public String decode(String shortUrl) {
//		return shortUrlToLong.get(shortUrl);
//	}
//
//	public static void main(String[] args) {
//		var instance = new ShortUrlMaker();
//		String actualShort = instance.encode(LONG_URL_1);
//		String actualLong = instance.decode(actualShort);
//		String expected = LONG_URL_1;
//		System.out.println("Long URL: " + LONG_URL_1 + " , short URL: " + actualShort);
//	}
//
//}





























