package com.sumin.someone;

public class EmailVO {
	private String id;
	private String content;
	private int time;
	
	public EmailVO() {
		// TODO Auto-generated constructor stub
	}

	public EmailVO(String id, String content, int time) {
		super();
		this.id = id;
		this.content = content;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "emailVO [id=" + id + ", content=" + content + ", time=" + time + "]";
	}
	
	

}
