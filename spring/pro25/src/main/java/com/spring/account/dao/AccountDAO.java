package com.spring.account.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.account.vo.AccountVO;

public interface AccountDAO {
	public void updateBalance1() throws DataAccessException;
	public void updateBalance2() throws DataAccessException;
	public List<AccountVO> selectAllAccountList();
}
