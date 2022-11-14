package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List listMembers() throws DataAccessException { // 회원 목록 보여주기
		List membersList = null;
			membersList = memberDAO.selectAllMemberList();
		
		return membersList;
	}
	
	public int addMember(MemberVO memberVO) throws DataAccessException { // 회원 추가하기
		return memberDAO.insertMember(memberVO);
	}
	
	public int removeMember(String id) throws DataAccessException { // 회원 삭제하기
		return memberDAO.deleteMember(id);
	}
	
	public int modMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.modMember(memberVO);
	}
}
