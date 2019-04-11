package com.vocabulary.io;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author Huang Da Ren
 */
public class SaladictHunterTest {

	private static SaladictHunter saladictHunter;

	@BeforeClass
	public static void prepare() {
		saladictHunter = new SaladictHunter();
	}

	@Test
	public void getWordsFromNutsTest() {
		String username = "huangdaren1997@gmail.com";
		String password = "a23s74hb5gjtpi3p";
		List<String> words = saladictHunter.getWordsFromNuts(username, password);
		System.out.println(words);
	}
}
