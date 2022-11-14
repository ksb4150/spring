package com.spring.pro30.board.service;

import java.util.List;
import java.util.Map;

import com.spring.pro30.board.vo.ArticleVO;
import com.spring.pro30.board.vo.ImageVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int insertNewArticle(Map articleMap) throws Exception;
	//public ArticleVO viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
	public Map viewArticle(int articleNO) throws Exception;
	public List<ImageVO> oldImageName(int articleNO) throws Exception;
}
