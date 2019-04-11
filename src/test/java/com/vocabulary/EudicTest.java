package com.vocabulary;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Huang Da Ren
 */
public class EudicTest {

	String url = "https://my.eudic.net/StudyList/ImportText";

	String accept = "application/json, text/javascript, */*; q=0.01";
	String acceptEncoding = "gzip, deflate, br";
	String acceptLang = "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7,zh-TW;q=0.6";
	String contentType = "application/x-www-form-urlencoded; charset=UTF-8";
	String cookie = "__cfduid=d2ce676e1fad80ed55600ee65efc2ea771554944535; __utma=131758875.597737998.1554944543.1554944543.1554944543.1; __utmc=131758875; __utmz=131758875.1554944543.1.1.utmcsr=github.com|utmccn=(referral)|utmcmd=referral|utmcct=/pinkomeo/bcz2txt; ASP.NET_SessionId=n3h1c5rq5cx02ahrfj0hof0b; col_index=6; col_sort=desc; __utmt=1; __utmb=131758875.10.10.1554944543; EudicWeb=0736346392AA845A7B67A4C55AD2222E5D42A186C9D75656A100AED6DD3E0F0479B71E3C81A85EE527E1D26F9932E3A3838BBEBBE3400F3411297787E381F3845A84E3A3AB4BA46D872634FFA5A637706972BAD44E8D6257571437341DDEBC1484FE9A9E2EC658CDD9C6D63B9EA3E920E3E622345C658345C49E37F36DA005E5DD6E3C56A75A2CB1FA702D4FC44F70CEF7C34619";
	String origin = "https://my.eudic.net";
	String referer = "https://my.eudic.net/studylist/import/";
	String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";


	static Map<String, Object> formData;

	@BeforeClass
	public static void prepareData() {
		formData = new HashMap<>();
		formData.put("sentenceText", "string \n chrome");
		formData.put("categoryid", "0");
		formData.put("cateNameInput", "");
		formData.put("isSingleWords", "true");
	}

	@Test
	public void updateWord() {
		HttpResponse response = HttpRequest.post(url)
				.form(formData)
				.header(Header.ACCEPT, accept)
				.header(Header.ACCEPT_ENCODING, acceptEncoding)
				.header(Header.ACCEPT_LANGUAGE, acceptLang)
				.header(Header.CONTENT_TYPE, contentType)
				.header(Header.USER_AGENT, userAgent)
				.header(Header.ORIGIN, origin)
				.header(Header.REFERER, referer)
				.header(Header.COOKIE, cookie)
				.execute();

		System.out.println(response.getStatus());
		String content = response.body();
		content = content.substring(3, content.length() - 1);
		System.out.println(content);
	}
}
