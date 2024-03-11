package com.sumin.someone.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumin.someone.MembersVO;
import com.sumin.someone.RandomVO;
import com.sumin.someone.ConnectVO;
import com.sumin.someone.SomeoneIf;

@Service("randomService")
public class RandomServiceimpl implements SomeoneIf{
	
	@Autowired
	RandomDAO randomDAO;
	
	
	
	public RandomServiceimpl(RandomDAO randomDAO) {
		super();
		this.randomDAO = randomDAO;
	}

	public RandomServiceimpl() {
		System.out.println("randomService 생성됨");
	}
	
	@Override
	public List<RandomVO> loadrandom_question() {
		return randomDAO.loadrandom_question();
	}

	@Override
	public List<MembersVO> loadmembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMembers(MembersVO vo) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void saveAnswer_(RandomVO vo) {
		randomDAO.saveAnswer_(vo);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMembers(MembersVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String insertConnect(MembersVO vo) {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public String insertConnect(ConnectVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConnectVO> checkConnect(ConnectVO vo) {
		return null;
		// TODO Auto-generated method stub

	}


}
