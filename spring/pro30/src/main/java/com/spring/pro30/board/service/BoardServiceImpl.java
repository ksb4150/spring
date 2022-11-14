package com.spring.pro30.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.pro30.board.dao.BoardDAO;
import com.spring.pro30.board.vo.ArticleVO;
import com.spring.pro30.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<ArticleVO> listArticles() throws Exception {
		List<ArticleVO> articlesList = boardDAO.selectAllArticlesList();

		System.out.println(articlesList.get(0).getArticleNO());
		return articlesList;
	}

	// 단일 이미지 추가하기
//	@Override
//	public int addNewArticle(Map articleMap) throws Exception {
//		
//		return boardDAO.insertNewArticle(articleMap);
//	}

	// 단일 파일 보이기
//	@Override
//	public ArticleVO viewArticle(int articleNO) throws Exception {
//		ArticleVO articleVO = boardDAO.viewArticle(articleNO);
//		
//		return articleVO;
//	}

//	@Override
//	public void modArticle(Map articleMap) throws Exception {
//		boardDAO.modArticle(articleMap);
//
//	}
	
	//다중 이미지 수정하기
	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.modArticle(articleMap);
		boardDAO.modImage(articleMap);
	}

	public List<ImageVO> oldImageName(int articleNO) throws Exception {
		List<ImageVO> oldImgNameList = boardDAO.oldImageName(articleNO);
		return oldImgNameList;
	}
	
	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.removeArticle(articleNO);
	}

	// 다중 이미지 추가하기
	@Override
	public int insertNewArticle(Map articleMap) throws Exception {
		int articleNO = boardDAO.insertNewArticle(articleMap); // 글 정보 추가
		articleMap.put("articleNO", articleNO);
		boardDAO.insertNewImage(articleMap); // 다중 이미지 추가

		return articleNO;
	}
	
	// 다중 파일 보이기
	@Override
	public Map viewArticle(int articleNO) throws Exception {
		Map articleMap = new HashMap();
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
		articleMap.put("article", articleVO);
		articleMap.put("imageFileList", imageFileList);

		return articleMap;
	}

}
