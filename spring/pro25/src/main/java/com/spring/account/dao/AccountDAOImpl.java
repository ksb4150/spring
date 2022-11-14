package com.spring.account.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.account.vo.AccountVO;

public class AccountDAOImpl implements AccountDAO {
	private SqlSession sqlSession;
	
	public AccountDAOImpl() {
		System.out.println("AccountDAOImpl 객체 생성");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("sqlSession : "+sqlSession);
		this.sqlSession = sqlSession;
	}

	@Override
	public void updateBalance1() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance1");
	}

	@Override
	public void updateBalance2() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance2");
	}
	
	@Override
	public List<AccountVO> selectAllAccountList() throws DataAccessException{
		List<AccountVO> accountsList = null;
		accountsList = sqlSession.selectList("mapper.account.selectAllAccountList");
		return accountsList;
	}
}
