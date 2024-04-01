package com.ipad.project.member.model;

public class MemberVO {
	private String id;
	private String pass1;
	private String pass2;
	private String email;
	private String name;
	private String tel;
	private String year;
	private String map;
	
	public MemberVO(String id, String pass1, String email, String name, String tel, String year, String map) {
		this.id = id;
		this.pass1 = pass1;
		this.email = email;
		this.name = name;
		this.tel = tel;
		this.year = year;
		this.map = map;
	}
	
	public MemberVO(String id) {
		this.id = id;
	}
	
	public MemberVO(String id, String pass1, String name) {
		this.id = id;
		this.pass1 = pass1;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
	
	
	
}
