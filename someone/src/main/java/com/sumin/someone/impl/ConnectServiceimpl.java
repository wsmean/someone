package com.sumin.someone.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumin.someone.MembersVO;
import com.sumin.someone.RandomVO;
import com.sumin.someone.ConnectVO;
import com.sumin.someone.SomeoneIf;

@Service("connectService")
public class ConnectServiceimpl implements SomeoneIf{
	
	@Autowired
	ConnectDAO connectDAO;

	public ConnectServiceimpl(ConnectDAO connectDAO) {
		super();
		this.connectDAO = connectDAO;
	}

	public ConnectServiceimpl() {
		// TODO Auto-generated constructor stub
		System.out.println("connectService 생성됨");
	}

	@Override
	public List<MembersVO> loadmembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RandomVO> loadrandom_question() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMembers(MembersVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAnswer_(RandomVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMembers(MembersVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String insertConnect(MembersVO vo) {
		return connectDAO.insertConnect(vo);
		
	}


	@Override
	public String insertConnect(ConnectVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConnectVO> checkConnect(ConnectVO vo) {
		// TODO Auto-generated method stub
		return ConnectDAO.checkConnect(vo);
	}



	
	
}
