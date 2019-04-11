package com.vocabulary.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取saladict存储在坚果云中的单词
 *
 * @author Huang Da Ren
 */
public class SaladictHunter implements VocabularyHunter {

	private final static String NOTEBOOK_URL = "https://dav.jianguoyun.com/dav/Saladict/notebook.json";

	/**
	 * 从坚果云中获取saladict通过webDAV方式存储的单词
	 *
	 * @param username 坚果云中的账号
	 * @param password 坚果云中的应用密码
	 * @return 一系列单词
	 */
	@SuppressWarnings("unchecked")
	public List<String> getWordsFromNuts(String username, String password) {
		try {
			Sardine sardine = SardineFactory.begin(username, password);
			InputStream jsonStream = sardine.get(NOTEBOOK_URL);
			ObjectMapper mapper = new ObjectMapper();
			List<Map> json = (List) mapper.readValue(jsonStream, Map.class).get("words");
			List words = new ArrayList();
			json.forEach(map -> words.add(map.get("text")));
			return words;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
