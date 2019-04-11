package com.vocabulary;

import com.vocabulary.service.VocabularyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.List;

/**
 * @author Huang Da Ren
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration(value = "src/main/web")
public class VocabularyServiceTest {

	@Autowired
	private VocabularyService vocabularyService;

	@Test
	public void listVocabulary() {
		String username = "huangdaren1997@gmail.com";
		String password = "a23s74hb5gjtpi3p";
		try {
			List words = vocabularyService.listVocabulary(username, password);
			System.out.println(words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
