package com.vocabulary.controller;

import com.vocabulary.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author Huang Da Ren
 */
@RestController("/")
public class VocabularyController {

	@Autowired
	private VocabularyService vocabularyService;

	@GetMapping
	public ModelAndView updateEudict(ModelAndView mv) {
		String username = "huangdaren1997@gmail.com";
		String password = "a23s74hb5gjtpi3p";
		boolean success = vocabularyService.updateEudict(username, password);
		mv.setViewName("index");
		if (success) {
			mv.addObject("msg", "成功更新单词");
		} else {
			mv.addObject("msg", "更新单词失败");
		}
		return mv;
	}

//	@GetMapping("words")
//	public ModelAndView listVocabulary(ModelAndView mv) throws IOException {
//		String username = "huangdaren1997@gmail.com";
//		String password = "a23s74hb5gjtpi3p";
//		List words = vocabularyService.listVocabulary(username, password);
//		mv.addObject("words", words);
//		mv.setViewName("index");
//		return mv;
//	}

}
