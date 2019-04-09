package com.vocabulary;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdr
 */
public class VocabularyReader {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String output = "/home/hdr/Desktop/words.txt";
		File outputFile = new File(output);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			ObjectMapper mapper = new ObjectMapper();
			Map json = mapper.readValue(new File("/home/hdr/Desktop/notebook.json"), Map.class);
			List<LinkedHashMap> words = (List) json.get("words");

			for (LinkedHashMap word : words) {
				bw.write(word.get("text") + "\n");
				bw.write(word.get("note") + "\n");
				bw.write(word.get("trans") + "\n");
				bw.write("----------------------------\n");
			}
		}

	}
}
