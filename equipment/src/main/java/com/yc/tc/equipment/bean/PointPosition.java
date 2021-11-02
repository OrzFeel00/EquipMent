package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PointPosition implements Serializable{

	/**
	 * 点位类
	 */
	private static final long serialVersionUID = 1L;

	//点位标识代码id   自增主键
	private Integer  pointId;
	//点位名称
	@NotEmpty(message = "不能为空")
	private String pointName;
	//断面编号
	@NotEmpty(message = "不能为空")
	private String sectionCode;
	//点位经度
	@NotEmpty(message = "不能为空")
	private String longitude;
	//点位纬度
	@NotEmpty(message = "不能为空")
	private String latitude;
	//监测点编码
	@NotEmpty(message = "不能为空")
	private String pointCode;
	//路口形状
	@NotEmpty(message = "不能为空")
	private String shape;
	//车道数   可以为0不为空
	@NotNull(message = "不能为空")
	private Integer LaneNumber;
	//点位类型
	@NotEmpty(message = "不能为空")
	private String pointType;
	//指向道路标识id
	private Integer  roadId;
	
	public PointPosition() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PointPosition [pointId=" + pointId + ", pointName=" + pointName + ", sectionCode=" + sectionCode
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", pointCode=" + pointCode + ", shape="
				+ shape + ", LaneNumber=" + LaneNumber + ", pointType=" + pointType + ", roadId=" + roadId + "]";
	}

	private PointPosition(Integer pointId, @NotEmpty(message = "不能为空") String pointName,
			@NotEmpty(message = "不能为空") String sectionCode, @NotEmpty(message = "不能为空") String longitude,
			@NotEmpty(message = "不能为空") String latitude, @NotEmpty(message = "不能为空") String pointCode,
			@NotEmpty(message = "不能为空") String shape, @NotNull(message = "不能为空") Integer laneNumber,
			@NotEmpty(message = "不能为空") String pointType, Integer roadId) {
		super();
		this.pointId = pointId;
		this.pointName = pointName;
		this.sectionCode = sectionCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.pointCode = pointCode;
		this.shape = shape;
		LaneNumber = laneNumber;
		this.pointType = pointType;
		this.roadId = roadId;
	}

	public Integer getPointId() {
		return pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPointCode() {
		return pointCode;
	}

	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Integer getLaneNumber() {
		return LaneNumber;
	}

	public void setLaneNumber(Integer laneNumber) {
		LaneNumber = laneNumber;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public Integer getRoadId() {
		return roadId;
	}

	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}

	

	
	
	

}
