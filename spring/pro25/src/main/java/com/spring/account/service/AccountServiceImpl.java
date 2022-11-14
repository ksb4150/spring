package com.spring.account.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.account.dao.AccountDAOImpl;
import com.spring.account.vo.AccountVO;

@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService{
	private AccountDAOImpl accDAO;
	
	public AccountServiceImpl() {
		System.out.println("AccountServiceImple 객체 생성");
	}
	
	public void setAccDAO(AccountDAOImpl accDAO) {
		System.out.println("accDAO : "+accDAO);
		this.accDAO = accDAO;
	}
	
	@Override
	public List<AccountVO> listAccounts() throws Exception{
		List<AccountVO> accountsList = null;
		accountsList = accDAO.selectAllAccountList();
		return accountsList;
	}
	@Override
	public void sendMoney() throws Exception{
		accDAO.updateBalance1();
		accDAO.updateBalance2();
	}
}
