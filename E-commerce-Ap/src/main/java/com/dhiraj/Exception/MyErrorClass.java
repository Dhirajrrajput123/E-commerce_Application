package com.dhiraj.Exception;

import java.time.LocalDateTime;

public class MyErrorClass {

	private LocalDateTime date;
	private String msg;
	private String desc;
	public MyErrorClass(LocalDateTime date, String msg, String desc) {
		super();
		this.date = date;
		this.msg = msg;
		this.desc = desc;
	}
	public MyErrorClass() {
		super();
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "MyErrorClass [date=" + date + ", msg=" + msg + ", desc=" + desc + "]";
	}
	
	
	
}
