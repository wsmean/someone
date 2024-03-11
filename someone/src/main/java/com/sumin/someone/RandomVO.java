package com.sumin.someone;

public class RandomVO {
	
	private int auto;
	private String question;
	private String mAnswer;
	private String cAnwer;
	
	public RandomVO() {

	}

	public RandomVO(int auto, String question, String mAnswer, String cAnwer) {
		super();
		this.auto = auto;
		this.question = question;
		this.mAnswer = mAnswer;
		this.cAnwer = cAnwer;
	}

	public int getAuto() {
		return auto;
	}

	public void setAuto(int auto) {
		this.auto = auto;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getmAnswer() {
		return mAnswer;
	}

	public void setmAnswer(String mAnswer) {
		this.mAnswer = mAnswer;
	}

	public String getcAnwer() {
		return cAnwer;
	}

	public void setcAnwer(String cAnwer) {
		this.cAnwer = cAnwer;
	}

	@Override
	public String toString() {
		return "randomVO [auto=" + auto + ", question=" + question + ", mAnswer=" + mAnswer + ", cAnwer=" + cAnwer
				+ "]";
	}
	
	
	
	
}
