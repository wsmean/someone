package com.sumin.someone.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sumin.someone.RandomVO;
import com.sumin.someone.SomeoneIf;

public class RandomTest {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		SomeoneIf randomService = (SomeoneIf) container.getBean("randomService");
		
		List<RandomVO> list = new ArrayList<RandomVO>();

		list = randomService.loadrandom_question();
			
		for(RandomVO randoms : list) {
			System.out.println("질문 : "+ randoms.getQuestion());
			System.out.println("내 답변 : "+ randoms.getmAnswer());
			System.out.println("커플 답변 : "+ randoms.getcAnwer());
		}
		
		container.close();
		
	}

}
