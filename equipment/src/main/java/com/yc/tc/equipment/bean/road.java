package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class road implements Serializable {

	/**
	 * 道路表    名称会有正反两种称呼 但是共用一个编号
	 */
	private static final long serialVersionUID = 1L;
	//道路标识id
	private Integer roadId;
	//行政区域
	@NotEmpty (message = "不能为空")
	private String administrativeRegion;
	//部门区域
	@NotEmpty (message = "不能为空")
	private String departmentRegion;
	//街道名称
	@NotEmpty (message = "不能为空")
	private String streetName;
	//道路名称
	@NotEmpty (message = "不能为空")
	private String roadName;
	//道路等级   国道省道等等
	@NotEmpty (message = "不能为空")
	private String roadGrade;
	//道路编码
	@NotEmpty (message = "不能为空")
	private String roadCode;
	//道路限速
	@NotEmpty (message = "不能为空")
	private String roadSpeed;
	
	
	public road() {
		super();
		// TODO Auto-generated constructor stub
	}


	public road(Integer roadId, @NotEmpty(message = "不能为空") String administrativeRegion,
			@NotEmpty(message = "不能为空") String departmentRegion, @NotEmpty(message = "不能为空") String streetName,
			@NotEmpty(message = "不能为空") String roadName, @NotEmpty(message = "不能为空") String roadGrade,
			@NotEmpty(message = "不能为空") String roadCode, @NotEmpty(message = "不能为空") String roadSpeed) {
		super();
		this.roadId = roadId;
		this.administrativeRegion = administrativeRegion;
		this.departmentRegion = departmentRegion;
		this.streetName = streetName;
		this.roadName = roadName;
		this.roadGrade = roadGrade;
		this.roadCode = roadCode;
		this.roadSpeed = roadSpeed;
	}


	@Override
	public String toString() {
		return "road [roadId=" + roadId + ", administrativeRegion=" + administrativeRegion + ", departmentRegion="
				+ departmentRegion + ", streetName=" + streetName + ", roadName=" + roadName + ", roadGrade="
				+ roadGrade + ", roadCode=" + roadCode + ", roadSpeed=" + roadSpeed + "]";
	}


	public Integer getRoadId() {
		return roadId;
	}


	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}


	public String getAdministrativeRegion() {
		return administrativeRegion;
	}


	public void setAdministrativeRegion(String administrativeRegion) {
		this.administrativeRegion = administrativeRegion;
	}


	public String getDepartmentRegion() {
		return departmentRegion;
	}


	public void setDepartmentRegion(String departmentRegion) {
		this.departmentRegion = departmentRegion;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getRoadName() {
		return roadName;
	}


	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}


	public String getRoadGrade() {
		return roadGrade;
	}


	public void setRoadGrade(String roadGrade) {
		this.roadGrade = roadGrade;
	}


	public String getRoadCode() {
		return roadCode;
	}


	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}


	public String getRoadSpeed() {
		return roadSpeed;
	}


	public void setRoadSpeed(String roadSpeed) {
		this.roadSpeed = roadSpeed;
	}
	
	
	
	
	
	
	

}
