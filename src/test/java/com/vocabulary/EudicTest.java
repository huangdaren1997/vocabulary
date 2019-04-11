package com.vocabulary;

import com.vocabulary.io.EudictUploader;
import com.vocabulary.io.SaladictHunter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Huang Da Ren
 */
public class EudicTest {


	private static List<String> words;

	@BeforeClass
	public static void prepare() {
		words = Arrays.asList("hello", "world", "you", "are", "so", "beautiful");
	}

	@Test
	public void uploadTest() {
		EudictUploader uploader = new EudictUploader();
		uploader.upload(words);
	}


	@Test
	public void SaladictAndEudicTest() {
		String username = "huangdaren1997@gmail.com";
		String password = "a23s74hb5gjtpi3p";
		SaladictHunter saladictHunter = new SaladictHunter();
		List<String> words = saladictHunter.getWordsFromNuts(username, password);
		EudictUploader uploader = new EudictUploader();
		boolean result = uploader.upload(words);
		Assert.assertTrue(result);
	}
}
