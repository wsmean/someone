package com.sumin.someone.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumin.someone.MembersVO;
import com.sumin.someone.RandomVO;
import com.sumin.someone.SomeoneIf;

@Controller
public class someoneController {
	
	@Autowired
	SomeoneIf randomService;
	
	@RequestMapping("/loadrandom_question.vm")
	@ResponseBody
	public List<RandomVO> loadrandom_question(){
		
		List<RandomVO> randomlist = new ArrayList<RandomVO>();
		System.out.println("Controller에서 loadrandom_question 호출");
		randomlist = randomService.loadrandom_question();
		
		return randomlist;
		}
	
	//답변 가져오기
	@RequestMapping("saveAnswer.vm")
	@ResponseBody
	public void saveAnswer_(RandomVO vo,
	@RequestParam
	(value = "mAnswer_", required = false) String randoms,
	@RequestParam
	(value = "auto_id", required = false) int ran)
	{System.out.println("받은 값 : "+randoms);
	{System.out.println("받은 값 : "+ran);
	vo.setAuto(ran);
	vo.setmAnswer(randoms);
	System.out.println(vo);
	randomService.saveAnswer_(vo);}
	
	}
	
	
	
	
	@RequestMapping("/test.vm")
	@ResponseBody
	List<RandomVO> loadrandom_question1(){
	
	List<RandomVO> randomlist = new ArrayList<RandomVO>();
	
	System.out.println("test1 호출");
	randomlist = randomService.loadrandom_question();
	
	return randomlist;
	}
	
	
	
	
	
}
