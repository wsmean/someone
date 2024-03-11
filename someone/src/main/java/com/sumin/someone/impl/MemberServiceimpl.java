package com.sumin.someone.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumin.someone.MembersVO;
import com.sumin.someone.RandomVO;
import com.sumin.someone.ConnectVO;
import com.sumin.someone.SomeoneIf;

@Service("memberService")
public class MemberServiceimpl implements SomeoneIf{
	
	@Autowired
	MermbersDAO membersDAO;
	
	public MemberServiceimpl() {
		System.out.println("memberService 생성됨");
	}
	
	@Override
	public List<MembersVO> loadmembers() {
		return membersDAO.loadmembers();
	}

	@Override
	public void insertMembers(MembersVO vo) {
		//여기서 memberservice 값 가져오기 
		membersDAO.insertMembers(vo);
		
	}

	@Override
	public List<RandomVO> loadrandom_question() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAnswer_(RandomVO vo) {
		return ;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMembers(MembersVO vo) {
		membersDAO.deleteMembers(vo);
		
	}

	@Override
	public String insertConnect(MembersVO vo) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ConnectVO> checkConnect(ConnectVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertConnect(ConnectVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
