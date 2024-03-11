package com.sumin.someone.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumin.someone.MembersVO;
import com.sumin.someone.SomeoneIf;

@Controller
public class randomController {
	
	@Autowired
	SomeoneIf memberService;
	
	//회원 정보 가져오기
		@RequestMapping("/insertMembers.vm")
		@ResponseBody
		public void insertMembers(MembersVO vo,
		@RequestParam
		(value = "j_id", required = false) String jid,
		@RequestParam
		(value = "j_pw", required = false) String jpw,
		@RequestParam
		(value = "j_name", required = false) String jname,
		@RequestParam
		(value = "j_email", required = false) String jemail)
		{System.out.println("jid : "+jid);
		System.out.println("j_pw : "+jpw);
		System.out.println("j_name : "+jname);
		System.out.println("j_email : "+jemail);
		vo.setId(jid);
		vo.setPassword(jpw);
		vo.setName(jname);
		vo.setEmail(jemail);
		System.out.println(vo);
		memberService.insertMembers(vo);
		}
		
		
		
		  @RequestMapping(value= "/deleteMembers1.vm")
		  @ResponseBody
		  public String deleteMembers(MembersVO vo,
		  @RequestParam
		  (value = "j_id1", required = false) String jid1){
		  System.out.println("회원 정보 삭제"); 
		  vo.setId(jid1);
		  System.out.println(vo);
		  memberService.deleteMembers(vo); 
		  return "index.html";
		  }
		 
		
		/*
		 * @RequestMapping("/test1.vm") public String deleteMembers(MembersVO vo) {
		 * System.out.println("회원 정보 삭제"); memberService.deleteMembers(vo); return
		 * "index.html"; }
		 */
		 
}
