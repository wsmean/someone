package com.sumin.someone.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumin.someone.MembersVO;
import com.sumin.someone.ConnectVO;
import com.sumin.someone.SomeoneIf;
import com.sumin.someone.impl.ConnectDAO;

@Controller
public class connectController {

	@Autowired
	SomeoneIf connectService;

	@RequestMapping(value = "/check_id.vm", method = RequestMethod.GET)
	@ResponseBody
	public String checkId(MembersVO vo, ConnectVO cvo, ConnectDAO connectDAO,
			@RequestParam(value = "m_id", required = false) String my_id,
			@RequestParam(value = "c_id", required = false) String cou_id) {

		// ajax에서 갖고 온 아이디 세팅
		System.out.println("1.아이디 여부 확인");
		vo.setId(my_id);
		vo.setId(cou_id);
		System.out.println("2.내 아이디는 : " + my_id);
		System.out.println("2.받은 아이디는 : " + cou_id);

		List<ConnectVO> user = ConnectDAO.checkConnect();
		user.getMyId();
		user.getCoupleId();
		System.out.println("4.받아온 내 아이디는?: " + cvo.getMyId());
		return cou_id;

		// 아이디 여부 확인

		/*
		 * if(user != null) { System.out.println("5.연결 가능한 회원이 있습니다.");
		 * connectService.insertConnect(vo);
		 * //System.out.println("user3: "+connectService.insertConnect(vo)); return
		 * "true";
		 * 
		 * } else{ System.out.println("아이디가 중복됩니다."); return "same"; }
		 * 
		 * 
		 * } else { System.out.println("5.연결 가능한 회원이 없습니다."); return "false"; }
		 */

	}

}
