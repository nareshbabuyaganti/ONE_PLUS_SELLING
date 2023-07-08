package com.sjp.life.insurance.initial.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientDto {
	@Id
	private String userName;
	private String createPassword;
	private String confirmPassword;
	@Column(unique = true)
	private String emailId;
	@Column(unique = true)
	private long phoneNumber;
	private String ratingCheck;
	private double rating;
	
	
	
	public String getRatingCheck() {
		return ratingCheck;
	}
	public void setRatingCheck(String ratingCheck) {
		this.ratingCheck = ratingCheck;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreatePassword() {
		return createPassword;
	}
	public void setCreatePassword(String createPassword) {
		this.createPassword = createPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	

}
