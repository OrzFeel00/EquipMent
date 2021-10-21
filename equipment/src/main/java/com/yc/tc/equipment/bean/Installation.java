package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class Installation implements Serializable{

	/**
	 * 设备安装类  记录点位的设备安装关系
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//安装位置
	@NotEmpty(message ="不能为空")
	private String installationPosition;
	//方向
	@NotEmpty(message ="不能为空")
	private String direction;
	//管理车道数   可以为0，不能为空
	@NotEmpty(message ="不能为空")
	private int lanes;
	//供电的点位标识id  不能为空
	@NotEmpty(message ="不能为空")
	private Integer  powerPoint;
	//指向 点位标识id 
	private Integer  pointId;
	//指向设备标识id  
	private Integer  equipmentId;
	//指向网络标识id
	private Integer  networkId;
	//指向 IP 表的  ip-id
	private Integer  ipId;
	
	public Installation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Installation(Integer id, @NotEmpty(message = "不能为空") String installationPosition,
			@NotEmpty(message = "不能为空") String direction, @NotEmpty(message = "不能为空") int lanes,
			@NotEmpty(message = "不能为空") Integer powerPoint, @NotEmpty(message = "不能为空") Integer pointId,
			@NotEmpty(message = "不能为空") Integer equipmentId, @NotEmpty(message = "不能为空") Integer networkId,
			@NotEmpty(message = "不能为空") Integer ipId) {
		super();
		this.id = id;
		this.installationPosition = installationPosition;
		this.direction = direction;
		this.lanes = lanes;
		this.powerPoint = powerPoint;
		this.pointId = pointId;
		this.equipmentId = equipmentId;
		this.networkId = networkId;
		this.ipId = ipId;
	}

	@Override
	public String toString() {
		return "Installation [id=" + id + ", installationPosition=" + installationPosition + ", direction=" + direction
				+ ", lanes=" + lanes + ", powerPoint=" + powerPoint + ", pointId=" + pointId + ", equipmentId="
				+ equipmentId + ", networkId=" + networkId + ", ipId=" + ipId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstallationPosition() {
		return installationPosition;
	}

	public void setInstallationPosition(String installationPosition) {
		this.installationPosition = installationPosition;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getLanes() {
		return lanes;
	}

	public void setLanes(int lanes) {
		this.lanes = lanes;
	}

	public Integer getPowerPoint() {
		return powerPoint;
	}

	public void setPowerPoint(Integer powerPoint) {
		this.powerPoint = powerPoint;
	}

	public Integer getPointId() {
		return pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Integer getNetworkId() {
		return networkId;
	}

	public void setNetworkId(Integer networkId) {
		this.networkId = networkId;
	}

	public Integer getIpId() {
		return ipId;
	}

	public void setIpId(Integer ipId) {
		this.ipId = ipId;
	}
	
	
	

}
