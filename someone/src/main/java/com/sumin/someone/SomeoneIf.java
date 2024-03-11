package com.sumin.someone;

import java.util.List;

public interface SomeoneIf {
	
	//회원 정보 load
	List<MembersVO> loadmembers();
	
	//random 리스트 load
	List<RandomVO> loadrandom_question();
	
	//회원 정보 저장
	void insertMembers(MembersVO vo);

	void saveAnswer_(RandomVO vo);
	
	void deleteMembers(MembersVO vo);

	String insertConnect(ConnectVO vo);

	List<ConnectVO> checkConnect(ConnectVO vo);

	String insertConnect(MembersVO vo);

	


	
}
