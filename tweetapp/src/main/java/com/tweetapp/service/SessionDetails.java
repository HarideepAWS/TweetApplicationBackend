package com.tweetapp.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SessionDetails {

	public SessionDetails(){
		this.isLogged=false;
	}
	
	private boolean isLogged;
	private Date inTime;
	private String mailId;
		
	
	
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
		
}
