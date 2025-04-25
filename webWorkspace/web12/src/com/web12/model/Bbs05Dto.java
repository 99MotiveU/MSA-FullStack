package com.web12.model;

import java.sql.Date;

// javaBean DTO
public class Bbs05Dto {
	private int num, cnt;
	private String sub, content;
	private Date nalja;

	public Bbs05Dto() {
	}

	public Bbs05Dto(int num, String sub, String content, int cnt, Date nalja) {
		super();
		this.num = num;
		this.cnt = cnt;
		this.sub = sub;
		this.content = content;
		this.nalja = nalja;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

}
