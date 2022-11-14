package com.spring.pro29.ex03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pro29.ex01.TestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	static Logger logger = LoggerFactory.getLogger(TestController.class);
	
//	@RequestMapping(value = "/all", method=RequestMethod.GET)
//	public ResponseEntity<List<ArticleVO>> listArticles() {
//		logger.info("listArticles 메서드 호출");
//		List<ArticleVO> list = new ArrayList<ArticleVO>();
//		
//		for(int i=0; i<10; i++) {
//			
//		}
//		
//		return list;
//	}
}
