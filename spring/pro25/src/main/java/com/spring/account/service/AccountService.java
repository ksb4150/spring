package com.spring.account.service;

import java.util.List;

import com.spring.account.vo.AccountVO;

public interface AccountService {
	public List<AccountVO> listAccounts() throws Exception;
	public void sendMoney() throws Exception;
}
