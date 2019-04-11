package com.vocabulary.io;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 把单词上传到欧陆单词的单词本
 *
 * @author Huang Da Ren
 */
public class EudictUploader implements VocabularyUploader {

	private static final String UPLOAD_SUCCESS = "单词导入成功";

	private static final String URL = "https://my.eudic.net/StudyList/ImportText";
	private static final String ACCEPT = "application/json, text/javascript, */*; q=0.01";
	private static final String ACCEPT_ENCODING = "gzip, deflate, br";
	private static final String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7,zh-TW;q=0.6";
	private static final String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
	private static final String ORIGIN = "https://my.eudic.net";
	private static final String REFERER = "https://my.eudic.net/studylist/import/";
	private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";


	private String cookie = "__cfduid=d2ce676e1fad80ed55600ee65efc2ea771554944535; __utma=131758875.597737998.1554944543.1554944543.1554944543.1; __utmc=131758875; __utmz=131758875.1554944543.1.1.utmcsr=github.com|utmccn=(referral)|utmcmd=referral|utmcct=/pinkomeo/bcz2txt; ASP.NET_SessionId=n3h1c5rq5cx02ahrfj0hof0b; col_index=6; col_sort=desc; __utmt=1; __utmb=131758875.10.10.1554944543; EudicWeb=0736346392AA845A7B67A4C55AD2222E5D42A186C9D75656A100AED6DD3E0F0479B71E3C81A85EE527E1D26F9932E3A3838BBEBBE3400F3411297787E381F3845A84E3A3AB4BA46D872634FFA5A637706972BAD44E8D6257571437341DDEBC1484FE9A9E2EC658CDD9C6D63B9EA3E920E3E622345C658345C49E37F36DA005E5DD6E3C56A75A2CB1FA702D4FC44F70CEF7C34619";

	@Override
	public boolean upload(List<String> words) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.size() - 1; i++) {
			sb.append(words.get(i));
			sb.append(" \n ");
		}
		sb.append(words.get(words.size() - 1));
		Map<String, Object> formData = new HashMap<>();
		formData.put("sentenceText", sb.toString());
		formData.put("categoryid", "0");
		formData.put("cateNameInput", "");
		formData.put("isSingleWords", "true");

		HttpResponse response = HttpRequest.post(URL)
				.form(formData)
				.header(Header.ACCEPT, ACCEPT)
				.header(Header.ACCEPT_ENCODING, ACCEPT_ENCODING)
				.header(Header.ACCEPT_LANGUAGE, ACCEPT_LANGUAGE)
				.header(Header.CONTENT_TYPE, CONTENT_TYPE)
				.header(Header.USER_AGENT, USER_AGENT)
				.header(Header.ORIGIN, ORIGIN)
				.header(Header.REFERER, REFERER)
				.header(Header.COOKIE, cookie)
				.execute();

		return response.body().contains(UPLOAD_SUCCESS);
	}
}
