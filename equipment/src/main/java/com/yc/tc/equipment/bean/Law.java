package com.yc.tc.equipment.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

public class Law implements Serializable{

	/**
	 * 执法信息表   设备有多个违法信息
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//监控设备标识id   设备包含监控设备
	private String equipmentName;
	//六合一编码
	@NotEmpty(message = "不能为空")
	private String coding;
	//高清平台代码
	@NotEmpty(message = "不能为空")
	private String platformCode;
	//集指设备备案编码
	@NotEmpty(message = "不能为空")
	private String filingCode;
	//公示时间
	@NotEmpty(message = "不能为空")
	private Timestamp publicityDate;
	//停机时间  可以为空
	private Timestamp downTime;
	//停机原因    可以为空
	@NotEmpty(message = "不能为空")
	private String shutdownReason;
	//限速值
	@NotEmpty(message = "不能为空")
	private String speedLimit;
	//启用时间   可以为空
	private Timestamp enableDate;
	//执法地址编码
	@NotEmpty(message = "不能为空")
	private String addressCode;
	//监控方向
	@NotEmpty(message = "不能为空")
	private String monitoringOrientation;
	//区间六合一编码
	@NotEmpty(message = "不能为空")
	private String intervalCoding;
	//区间测速终点
	@NotEmpty(message = "不能为空")
	private String measurementPoint;
	//设备功能启用
	@NotEmpty(message = "不能为空")
	private String functionEnabled;
	//执法地址    （！是否为点位）
	@NotEmpty(message = "不能为空")
	private String lawAddress;
	//卡口用途
	@NotEmpty(message = "不能为空")
	private String bayonetPurpose;
	//违法地点代码   （！是否为点位）
	@NotEmpty(message = "不能为空")
	private String llegalCode;
	//方向编码
	@NotEmpty(message = "不能为空")
	private String directionCoding;
	
	
	public Law() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Law [id=" + id + ", equipmentName=" + equipmentName + ", coding=" + coding + ", platformCode="
				+ platformCode + ", filingCode=" + filingCode + ", publicityDate=" + publicityDate + ", downTime="
				+ downTime + ", shutdownReason=" + shutdownReason + ", speedLimit=" + speedLimit + ", enableDate="
				+ enableDate + ", addressCode=" + addressCode + ", monitoringOrientation=" + monitoringOrientation
				+ ", intervalCoding=" + intervalCoding + ", measurementPoint=" + measurementPoint + ", functionEnabled="
				+ functionEnabled + ", lawAddress=" + lawAddress + ", bayonetPurpose=" + bayonetPurpose
				+ ", llegalCode=" + llegalCode + ", directionCoding=" + directionCoding + "]";
	}


	private Law(Integer id, String equipmentName, @NotEmpty(message = "不能为空") String coding,
			@NotEmpty(message = "不能为空") String platformCode, @NotEmpty(message = "不能为空") String filingCode,
			@NotEmpty(message = "不能为空") Timestamp publicityDate, Timestamp downTime,
			@NotEmpty(message = "不能为空") String shutdownReason, @NotEmpty(message = "不能为空") String speedLimit,
			Timestamp enableDate, @NotEmpty(message = "不能为空") String addressCode,
			@NotEmpty(message = "不能为空") String monitoringOrientation, @NotEmpty(message = "不能为空") String intervalCoding,
			@NotEmpty(message = "不能为空") String measurementPoint, @NotEmpty(message = "不能为空") String functionEnabled,
			@NotEmpty(message = "不能为空") String lawAddress, @NotEmpty(message = "不能为空") String bayonetPurpose,
			@NotEmpty(message = "不能为空") String llegalCode, @NotEmpty(message = "不能为空") String directionCoding) {
		super();
		this.id = id;
		this.equipmentName = equipmentName;
		this.coding = coding;
		this.platformCode = platformCode;
		this.filingCode = filingCode;
		this.publicityDate = publicityDate;
		this.downTime = downTime;
		this.shutdownReason = shutdownReason;
		this.speedLimit = speedLimit;
		this.enableDate = enableDate;
		this.addressCode = addressCode;
		this.monitoringOrientation = monitoringOrientation;
		this.intervalCoding = intervalCoding;
		this.measurementPoint = measurementPoint;
		this.functionEnabled = functionEnabled;
		this.lawAddress = lawAddress;
		this.bayonetPurpose = bayonetPurpose;
		this.llegalCode = llegalCode;
		this.directionCoding = directionCoding;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEquipmentName() {
		return equipmentName;
	}


	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}


	public String getCoding() {
		return coding;
	}


	public void setCoding(String coding) {
		this.coding = coding;
	}


	public String getPlatformCode() {
		return platformCode;
	}


	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}


	public String getFilingCode() {
		return filingCode;
	}


	public void setFilingCode(String filingCode) {
		this.filingCode = filingCode;
	}


	public Timestamp getPublicityDate() {
		return publicityDate;
	}


	public void setPublicityDate(Timestamp publicityDate) {
		this.publicityDate = publicityDate;
	}


	public Timestamp getDownTime() {
		return downTime;
	}


	public void setDownTime(Timestamp downTime) {
		this.downTime = downTime;
	}


	public String getShutdownReason() {
		return shutdownReason;
	}


	public void setShutdownReason(String shutdownReason) {
		this.shutdownReason = shutdownReason;
	}


	public String getSpeedLimit() {
		return speedLimit;
	}


	public void setSpeedLimit(String speedLimit) {
		this.speedLimit = speedLimit;
	}


	public Timestamp getEnableDate() {
		return enableDate;
	}


	public void setEnableDate(Timestamp enableDate) {
		this.enableDate = enableDate;
	}


	public String getAddressCode() {
		return addressCode;
	}


	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}


	public String getMonitoringOrientation() {
		return monitoringOrientation;
	}


	public void setMonitoringOrientation(String monitoringOrientation) {
		this.monitoringOrientation = monitoringOrientation;
	}


	public String getIntervalCoding() {
		return intervalCoding;
	}


	public void setIntervalCoding(String intervalCoding) {
		this.intervalCoding = intervalCoding;
	}


	public String getMeasurementPoint() {
		return measurementPoint;
	}


	public void setMeasurementPoint(String measurementPoint) {
		this.measurementPoint = measurementPoint;
	}


	public String getFunctionEnabled() {
		return functionEnabled;
	}


	public void setFunctionEnabled(String functionEnabled) {
		this.functionEnabled = functionEnabled;
	}


	public String getLawAddress() {
		return lawAddress;
	}


	public void setLawAddress(String lawAddress) {
		this.lawAddress = lawAddress;
	}


	public String getBayonetPurpose() {
		return bayonetPurpose;
	}


	public void setBayonetPurpose(String bayonetPurpose) {
		this.bayonetPurpose = bayonetPurpose;
	}


	public String getLlegalCode() {
		return llegalCode;
	}


	public void setLlegalCode(String llegalCode) {
		this.llegalCode = llegalCode;
	}


	public String getDirectionCoding() {
		return directionCoding;
	}


	public void setDirectionCoding(String directionCoding) {
		this.directionCoding = directionCoding;
	}


	
	
	
	

}
