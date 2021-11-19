package com.yc.tc.equipment.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Devops implements Serializable{

	/**
	 * 设备运维信息类  项目里的设备的运维信息
	 */
	private static final long serialVersionUID = 1L;
	
	//维护标识id
	private Integer devopsId;
	//产权归属
	@NotEmpty(message = "不能为空")
	private String ownership;
	//维护性质
	@NotEmpty(message = "不能为空")
	private String devopsNature;
	//维护单位
	@NotEmpty(message = "不能为空")
	private String devopsUnit;
	//维护状态
	@NotEmpty(message = "不能为空")
	private String devopsStatus;
	//联网校时状态
	@NotEmpty(message = "不能为空")
	private String onlineTimingStatus;
	//是否质保期    0为否 1为是
	@NotEmpty(message = "不能为空")
	private int warrantyPeriod;
	//相机更换时间
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//出
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//入
	private Date cameraReplacementTime;
	//运维负责人
	@NotEmpty(message = "不能为空")
	private String devopsLiable;
	//运维负责人联系电话
	@NotEmpty(message = "不能为空")
	private String devopsPhone;
	//指向 项目标识
	private String projectName;
	//指向 设备标识
	private String equipmentName;
	//指向 设备点位 
	private String pointName;
	
	@Override
	public String toString() {
		return "Devops [devopsId=" + devopsId + ", ownership=" + ownership + ", devopsNature=" + devopsNature
				+ ", devopsUnit=" + devopsUnit + ", devopsStatus=" + devopsStatus + ", onlineTimingStatus="
				+ onlineTimingStatus + ", warrantyPeriod=" + warrantyPeriod + ", cameraReplacementTime="
				+ cameraReplacementTime + ", devopsLiable=" + devopsLiable + ", devopsPhone=" + devopsPhone
				+ ", projectName=" + projectName + ", equipmentName=" + equipmentName + ", pointName=" + pointName
				+ "]";
	}

	private Devops(Integer devopsId, @NotEmpty(message = "不能为空") String ownership,
			@NotEmpty(message = "不能为空") String devopsNature, @NotEmpty(message = "不能为空") String devopsUnit,
			@NotEmpty(message = "不能为空") String devopsStatus, @NotEmpty(message = "不能为空") String onlineTimingStatus,
			@NotEmpty(message = "不能为空") int warrantyPeriod, Date cameraReplacementTime,
			@NotEmpty(message = "不能为空") String devopsLiable, @NotEmpty(message = "不能为空") String devopsPhone,
			String projectName, String equipmentName, String pointName) {
		super();
		this.devopsId = devopsId;
		this.ownership = ownership;
		this.devopsNature = devopsNature;
		this.devopsUnit = devopsUnit;
		this.devopsStatus = devopsStatus;
		this.onlineTimingStatus = onlineTimingStatus;
		this.warrantyPeriod = warrantyPeriod;
		this.cameraReplacementTime = cameraReplacementTime;
		this.devopsLiable = devopsLiable;
		this.devopsPhone = devopsPhone;
		this.projectName = projectName;
		this.equipmentName = equipmentName;
		this.pointName = pointName;
	}

	private Devops() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDevopsId() {
		return devopsId;
	}

	public void setDevopsId(Integer devopsId) {
		this.devopsId = devopsId;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getDevopsNature() {
		return devopsNature;
	}

	public void setDevopsNature(String devopsNature) {
		this.devopsNature = devopsNature;
	}

	public String getDevopsUnit() {
		return devopsUnit;
	}

	public void setDevopsUnit(String devopsUnit) {
		this.devopsUnit = devopsUnit;
	}

	public String getDevopsStatus() {
		return devopsStatus;
	}

	public void setDevopsStatus(String devopsStatus) {
		this.devopsStatus = devopsStatus;
	}

	public String getOnlineTimingStatus() {
		return onlineTimingStatus;
	}

	public void setOnlineTimingStatus(String onlineTimingStatus) {
		this.onlineTimingStatus = onlineTimingStatus;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Date getCameraReplacementTime() {
		return cameraReplacementTime;
	}

	public void setCameraReplacementTime(Date cameraReplacementTime) {
		this.cameraReplacementTime = cameraReplacementTime;
	}

	public String getDevopsLiable() {
		return devopsLiable;
	}

	public void setDevopsLiable(String devopsLiable) {
		this.devopsLiable = devopsLiable;
	}

	public String getDevopsPhone() {
		return devopsPhone;
	}

	public void setDevopsPhone(String devopsPhone) {
		this.devopsPhone = devopsPhone;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	
	
	
	
	
	
	
	

}
