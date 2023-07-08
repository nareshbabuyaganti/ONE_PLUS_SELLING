package com.sjp.life.insurance.initial.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MobileDto {
	
	@Id
	private String MODEL_NAME;
	private String proccessor;
	private int batteryCapacity;
	private int ram;
	private int rom;
	private int cost;
	private String imageFront;
	private String imageBack;
	private String imageSide;
	private double overAllRating;
	private double display;
	private int frontCam;
	private int backCam;
	private double discount;
	
	public String getMODEL_NAME() {
		return MODEL_NAME;
	}
	public void setMODEL_NAME(String mODEL_NAME) {
		MODEL_NAME = mODEL_NAME;
	}
	public String getImageFront() {
		return imageFront;
	}
	public void setImageFront(String imagefront) {
		this.imageFront = imagefront;
	}
	public String getImageBack() {
		return imageBack;
	}
	public void setImageBack(String imageBack) {
		this.imageBack = imageBack;
	}
	public String getImageSide() {
		return imageSide;
	}
	public void setImageSide(String imageSide) {
		this.imageSide = imageSide;
	}
	public double getOverAllRating() {
		return overAllRating;
	}
	public void setOverAllRating(double rating) {
		this.overAllRating = rating;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getProccessor() {
		return proccessor;
	}
	public void setProccessor(String proccessor) {
		this.proccessor = proccessor;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int mobileCapacity) {
		this.batteryCapacity = mobileCapacity;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRom() {
		return rom;
	}
	public void setRom(int rom) {
		this.rom = rom;
	}
	public double getDisplay() {
		return display;
	}
	public void setDisplay(double display) {
		this.display = display;
	}
	public int getFrontCam() {
		return frontCam;
	}
	public void setFrontCam(int frontCam) {
		this.frontCam = frontCam;
	}
	public int getBackCam() {
		return backCam;
	}
	public void setBackCam(int backCam) {
		this.backCam = backCam;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
