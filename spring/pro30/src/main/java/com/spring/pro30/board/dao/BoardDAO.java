package com.spring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.pro30.board.vo.ArticleVO;
import com.spring.pro30.board.vo.ImageVO;

public interface BoardDAO {
	public List selectAllArticlesList() throws Exception;
	public int insertNewArticle(Map articleMap) throws Exception;
	public ArticleVO viewArticle(int articleNo) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
	public void insertNewImage(Map articleMap);
	public ArticleVO selectArticle(int articleNO) throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;
	public void modImage(Map articleMap);
	public List<ImageVO> oldImageName(int articleNO) throws Exception;
}