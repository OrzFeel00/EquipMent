package com.yc.tc.equipment.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yc.tc.equipment.validation.ipvalid;

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
	@NotNull(message ="不能为空")
	private int lanes;
	//供电的点位标识name 不能为空
	private String  powerPoint;
	//指向 点位标识name
	private String  pointName;
	//指向设备标识name
	private String  equipmentName;
	//网络
	//传输类型
	@NotEmpty(message = "不能为空")
	private String  transmissionType;
	//接入机房
	@NotEmpty(message = "不能为空")
	private String  computerRoom;
	//联网属性
	@NotEmpty(message = "不能为空")
	private String  networkAttribute;
	//通讯卡号
	@NotNull(message = "不能为空")
	private Integer  idcard;
	//接入网络
	@NotEmpty(message = "不能为空")
	private String  accessNetwork;
	//路由
	@NotEmpty(message = "不能为空")
	private String  router;
	//联网校时功能
	@NotEmpty(message = "不能为空")
	private String  networkTiming;
	//校时情况预警功能
	@NotEmpty(message = "不能为空")
	private String  timingWarning;
	//检定有效截止时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//出
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//入
	private Date  verificationDeadline;
   // IP 表的 
   //ip地址
	@NotEmpty(message ="不能为空")
	private String ip;
	//mac地址   
	@NotEmpty(message = "不能为空")
	private String mac;
	//端口号
	@NotNull(message = "不能为空")
	private int prot;
	
	@Override
	public String toString() {
		return "Installation [id=" + id + ", installationPosition=" + installationPosition + ", direction=" + direction
				+ ", lanes=" + lanes + ", powerPoint=" + powerPoint + ", pointName=" + pointName + ", equipmentName="
				+ equipmentName + ", transmissionType=" + transmissionType + ", computerRoom=" + computerRoom
				+ ", networkAttribute=" + networkAttribute + ", idcard=" + idcard + ", accessNetwork=" + accessNetwork
				+ ", router=" + router + ", networkTiming=" + networkTiming + ", timingWarning=" + timingWarning
				+ ", verificationDeadline=" + verificationDeadline + ", ip=" + ip + ", mac=" + mac + ", prot=" + prot
				+ "]";
	}

	private Installation() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Installation(Integer id, @NotEmpty(message = "不能为空") String installationPosition,
			@NotEmpty(message = "不能为空") String direction, @NotNull(message = "不能为空") int lanes, String powerPoint,
			String pointName, String equipmentName, @NotEmpty(message = "不能为空") String transmissionType,
			@NotEmpty(message = "不能为空") String computerRoom, @NotEmpty(message = "不能为空") String networkAttribute,
			@NotNull(message = "不能为空") Integer idcard, @NotEmpty(message = "不能为空") String accessNetwork,
			@NotEmpty(message = "不能为空") String router, @NotEmpty(message = "不能为空") String networkTiming,
			@NotEmpty(message = "不能为空") String timingWarning, Date verificationDeadline,
			@NotEmpty(message = "不能为空") String ip, @NotEmpty(message = "不能为空") String mac,
			@NotNull(message = "不能为空") int prot) {
		super();
		this.id = id;
		this.installationPosition = installationPosition;
		this.direction = direction;
		this.lanes = lanes;
		this.powerPoint = powerPoint;
		this.pointName = pointName;
		this.equipmentName = equipmentName;
		this.transmissionType = transmissionType;
		this.computerRoom = computerRoom;
		this.networkAttribute = networkAttribute;
		this.idcard = idcard;
		this.accessNetwork = accessNetwork;
		this.router = router;
		this.networkTiming = networkTiming;
		this.timingWarning = timingWarning;
		this.verificationDeadline = verificationDeadline;
		this.ip = ip;
		this.mac = mac;
		this.prot = prot;
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

	public String getPowerPoint() {
		return powerPoint;
	}

	public void setPowerPoint(String powerPoint) {
		this.powerPoint = powerPoint;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getComputerRoom() {
		return computerRoom;
	}

	public void setComputerRoom(String computerRoom) {
		this.computerRoom = computerRoom;
	}

	public String getNetworkAttribute() {
		return networkAttribute;
	}

	public void setNetworkAttribute(String networkAttribute) {
		this.networkAttribute = networkAttribute;
	}

	public Integer getIdcard() {
		return idcard;
	}

	public void setIdcard(Integer idcard) {
		this.idcard = idcard;
	}

	public String getAccessNetwork() {
		return accessNetwork;
	}

	public void setAccessNetwork(String accessNetwork) {
		this.accessNetwork = accessNetwork;
	}

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getNetworkTiming() {
		return networkTiming;
	}

	public void setNetworkTiming(String networkTiming) {
		this.networkTiming = networkTiming;
	}

	public String getTimingWarning() {
		return timingWarning;
	}

	public void setTimingWarning(String timingWarning) {
		this.timingWarning = timingWarning;
	}

	public Date getVerificationDeadline() {
		return verificationDeadline;
	}

	public void setVerificationDeadline(Date verificationDeadline) {
		this.verificationDeadline = verificationDeadline;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		this.prot = prot;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	

}
