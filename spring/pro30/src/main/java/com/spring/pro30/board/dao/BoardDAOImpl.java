package com.spring.pro30.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.pro30.board.vo.ArticleVO;
import com.spring.pro30.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllArticlesList() throws Exception {
		List<ArticleVO> articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}
	
	@Override
	public int insertNewArticle(Map articleMap) throws Exception {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mapper.board.insertNewArticle",articleMap);
		return articleNO;
	}

	@Override
	public ArticleVO viewArticle(int articleNo) throws Exception {
		return sqlSession.selectOne("mapper.board.selectArticle", articleNo);
	}

//	@Override
//	public void modArticle(Map articleMap) throws Exception {
//		sqlSession.update("mapper.board.updateArticle", articleMap);
//	}

	@Override
	public void modArticle(Map articleMap) throws Exception {
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}
	
	@Override
	public void modImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		 int articleNO = Integer.parseInt((String) articleMap.get("articleNO")); 
		/* int articleNO = (Integer)articleMap.get("articleNO"); */
		
		for(ImageVO imageVO : imageFileList) {
			imageVO.setArticleNO(articleNO);
		}
		
		sqlSession.update("mapper.board.updateImage", imageFileList);
	}
	
	public List<ImageVO> oldImageName(int articleNO) throws Exception {
		List<ImageVO> oldImgNameList = sqlSession.selectList("mapper.board.oldImageName", articleNO);
		
		return oldImgNameList;
	}
	
	@Override
	public void removeArticle(int articleNO) throws Exception {
		sqlSession.delete("mapper.board.deleteArticle", articleNO);		
	}

	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}
	
	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
	}
	
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		
		for(ImageVO imageVO : imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		
		sqlSession.insert("mapper.board.insertNewImage", imageFileList);
	}
	
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.selectImageFileList",articleNO);
		return imageFileList;
	}

	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}
	
}
