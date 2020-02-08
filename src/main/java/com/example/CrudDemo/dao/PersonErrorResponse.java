package com.example.CrudDemo.dao;

public class PersonErrorResponse {
	private int status;
	private String message;
	private long timestamp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "PersonErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp
				+ ", getStatus()=" + getStatus() + ", getMessage()=" + getMessage() + ", getTimestamp()="
				+ getTimestamp() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
