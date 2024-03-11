package com.sumin.someone.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumin.someone.MembersVO;
import com.sumin.someone.impl.ConnectDAO;
import com.sumin.someone.impl.LoginDAO;


@Controller
public class LoginController {
	
	@RequestMapping(value="/login.vm", method = RequestMethod.GET)
	@ResponseBody
	public String getLogin(MembersVO vo, LoginDAO loginDAO, ConnectDAO connectDAO,
	@RequestParam
	(value = "id_", required = false) String id1,
	@RequestParam
	(value = "pw_", required = false) String pw1) {
		System.out.println("로그인 인증 처리...");
		if (id1 == null || id1.equals("")) {
			throw new ArithmeticException("아이디는 반드시 입력해야 합니다.");
				
		}if(pw1 == null || pw1.equals("")){
				throw new ArithmeticException("비밀번호는 반드시 입력해야 합니다.");
			
		}
		vo.setId(id1);
		vo.setPassword(pw1);
		System.out.println(id1);
		System.out.println(pw1);
		
		MembersVO user = loginDAO.goLogin(vo);
		System.out.println("값은?:" + user);
		//화면 출력
		//ajax에서 data 값으로 나오는 것!!
		if(user != null) {
			System.out.println("로그인 성공 ");
			//성공시에 connect 정보 갖고 오기
			return user.getId();
		}else {
			System.out.println("아이디가 틀렸습니다.");
			return "";
		}
		
	}
	
	@RequestMapping(value="/join_check.vm", method = RequestMethod.GET)
	@ResponseBody
	public String getLogin(MembersVO vo, LoginDAO loginDAO,
	@RequestParam
	(value = "id_", required = false) String id1) {
		System.out.println("1. 아이디 중복확인 처리...");
		/*
		 * if (id1 == null || id1.equals("")) { throw new
		 * ArithmeticException("아이디는 반드시 입력해야 합니다.");
		 * 
		 * }
		 */
		vo.setId(id1);
		System.out.println("2."+id1);
		
		MembersVO user = loginDAO.join_check(vo);
		System.out.println("4.값은?:" + user);
		
		//화면 출력
		//ajax에서 data 값으로 나오는 것!!
		if(user != null) {
			System.out.println("5.아이디 사용 불가 ");
			return "true";
		}else {
			System.out.println("5.아이디 사용 가능");
			return "false";
		}
		
	}

}
