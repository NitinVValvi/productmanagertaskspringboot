package com.productmanager.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {
private int statuscode;
private Date tDate;
private HttpStatus error;
private String errormsg;
private String path;
public ApiError() {
	// TODO Auto-generated constructor stub
}


public HttpStatus getError() {
	return error;
}


public ApiError(int statuscode, Date tDate, HttpStatus error, String errormsg, String path) {
	super();
	this.statuscode = statuscode;
	this.tDate = tDate;
	this.error = error;
	this.errormsg = errormsg;
	this.path = path;
}


public void setError(HttpStatus error) {
	this.error = error;
}


public int getStatuscode() {
	return statuscode;
}
public void setStatuscode(int statuscode) {
	this.statuscode = statuscode;
}
public Date gettDate() {
	return tDate;
}
public void settDate(Date tDate) {
	this.tDate = tDate;
}
public String getErrormsg() {
	return errormsg;
}
public void setErrormsg(String errormsg) {
	this.errormsg = errormsg;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}

}
