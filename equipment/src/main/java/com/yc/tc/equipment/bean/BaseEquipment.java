package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BaseEquipment implements Serializable{

	/**
	 * 设备基础信息类  和设备类一对一
	 */
	private static final long serialVersionUID = 1L;
	//设备基础 标识id
	private Integer baseEquipmentId;
	//出厂序列号   唯一索引
	@NotEmpty(message = "不能为空")
	private String sn;
	//型号
	@NotEmpty(message = "不能为空")
	private String modelNumber;
	//硬盘数量  可以为0
	private int diskNumber;
	//图像帧率
	@NotEmpty(message = "不能为空")
	private String frameRate;
	//设备品牌
	@NotEmpty(message = "不能为空")
	private String brand;
	//图像分辨率
	@NotEmpty(message = "不能为空")
	private String resolvingPower;
	//设备功能类型
	@NotEmpty(message = "不能为空")
	private String functionType;
	//版本号
	@NotEmpty(message = "不能为空")
	private String versionNumber;
	//主机通道数    可以为0
	@NotNull(message = "不能为空")
	private Integer hostchannelsNumber;
	//设备高度
	@NotNull(message = "不能为空")
	private double height;
	//设备长度
	@NotNull(message = "不能为空")
	private double length;
	
	
	public BaseEquipment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BaseEquipment(@NotEmpty(message = "不能为空") String sn, @NotEmpty(message = "不能为空") String modelNumber,
			int diskNumber, @NotEmpty(message = "不能为空") String frameRate, @NotEmpty(message = "不能为空") String brand,
			@NotEmpty(message = "不能为空") String resolvingPower, @NotEmpty(message = "不能为空") String functionType,
			@NotEmpty(message = "不能为空") String versionNumber, @NotEmpty(message = "不能为空") int hostchannelsNumber,
			@NotEmpty(message = "不能为空") double height, @NotEmpty(message = "不能为空") double length) {
		super();
		this.sn = sn;
		this.modelNumber = modelNumber;
		this.diskNumber = diskNumber;
		this.frameRate = frameRate;
		this.brand = brand;
		this.resolvingPower = resolvingPower;
		this.functionType = functionType;
		this.versionNumber = versionNumber;
		this.hostchannelsNumber = hostchannelsNumber;
		this.height = height;
		this.length = length;
	}


	@Override
	public String toString() {
		return "BaseEquipment [baseEquipmentId=" + baseEquipmentId + ", sn=" + sn + ", modelNumber=" + modelNumber
				+ ", diskNumber=" + diskNumber + ", frameRate=" + frameRate + ", brand=" + brand + ", resolvingPower="
				+ resolvingPower + ", functionType=" + functionType + ", versionNumber=" + versionNumber
				+ ", hostchannelsNumber=" + hostchannelsNumber + ", height=" + height + ", length=" + length + "]";
	}


	public Integer getBaseEquipmentId() {
		return baseEquipmentId;
	}


	public void setBaseEquipmentId(Integer baseEquipmentId) {
		this.baseEquipmentId = baseEquipmentId;
	}


	public String getSn() {
		return sn;
	}


	public void setSn(String sn) {
		this.sn = sn;
	}


	public String getModelNumber() {
		return modelNumber;
	}


	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}


	public int getDiskNumber() {
		return diskNumber;
	}


	public void setDiskNumber(int diskNumber) {
		this.diskNumber = diskNumber;
	}


	public String getFrameRate() {
		return frameRate;
	}


	public void setFrameRate(String frameRate) {
		this.frameRate = frameRate;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getResolvingPower() {
		return resolvingPower;
	}


	public void setResolvingPower(String resolvingPower) {
		this.resolvingPower = resolvingPower;
	}


	public String getFunctionType() {
		return functionType;
	}


	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}


	public String getVersionNumber() {
		return versionNumber;
	}


	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}


	public int getHostchannelsNumber() {
		return hostchannelsNumber;
	}


	public void setHostchannelsNumber(int hostchannelsNumber) {
		this.hostchannelsNumber = hostchannelsNumber;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}
	
	
	
	
	
	
	

}
