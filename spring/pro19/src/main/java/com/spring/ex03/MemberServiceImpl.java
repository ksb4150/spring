package com.spring.ex03;

public class MemberServiceImpl  implements MemberService {
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		System.out.println("MemberServiceImpl 생성자 호출");
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
}
