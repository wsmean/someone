package com.sumin.someone;

public class MembersVO {
	
	private int auto;
	private String name;
	private String id;
	private String password;
	private String email;
	
	private String m_id2;
	private String id2;
	

	public MembersVO(int auto, String name, String id, String password, String email) {
		super();
		this.auto = auto;
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public MembersVO() {
		// TODO Auto-generated constructor stub
	}

	public int getAuto() {
		return auto;
	}

	public void setAuto(int auto) {
		this.auto = auto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getM_id2() {
		return m_id2;
	}

	public void setM_id2(String m_id2) {
		this.m_id2 = m_id2;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	@Override
	public String toString() {
		return "MembersVO [auto=" + auto + ", name=" + name + ", id=" + id + ", password=" + password + ", email="
				+ email + "]";
	}
	
	

	

}
