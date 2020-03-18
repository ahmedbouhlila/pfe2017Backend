package org.Poly.Json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JsonMessage {

	private String message;
	private String   qui;
	
	private Date date ;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getQui() {
		return qui;
	}
	public void setQui(String qui) {
		this.qui = qui;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
 
		  	
	
	
}
