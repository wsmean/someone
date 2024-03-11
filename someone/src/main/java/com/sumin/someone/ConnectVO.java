package com.sumin.someone;

import java.sql.Date;

public class ConnectVO {
	private String myId;
	private String coupleId;
	private Date time;
	
	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public String getCoupleId() {
		return coupleId;
	}

	public void setCoupleId(String coupleId) {
		this.coupleId = coupleId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public ConnectVO(String myId, String coupleId, Date time) {
		super();
		this.myId = myId;
		this.coupleId = coupleId;
		this.time = time;
	}
	
}
