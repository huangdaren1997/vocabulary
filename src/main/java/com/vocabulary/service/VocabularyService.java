package com.vocabulary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Huang Da Ren
 */
@Service
public class VocabularyService {

	private static Logger logger = LoggerFactory.getLogger(VocabularyService.class.getName());

	private final static String JSON_WORD_URL = "https://dav.jianguoyun.com/dav/Saladict/notebook.json";

	public List listVocabulary(String username, String password) throws IOException {
		logger.info("开始创建sardine.............");
		Sardine sardine = SardineFactory.begin(username, password);
		logger.info("开始获取json_stream............");
		InputStream jsonStream = sardine.get(JSON_WORD_URL);
		ObjectMapper mapper = new ObjectMapper();
		Map json = mapper.readValue(jsonStream, Map.class);
		logger.info(json.toString());
		return (List) json.get("words");

	}

	public void updateEudict() {

	}

}
