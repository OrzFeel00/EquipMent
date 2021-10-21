package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class NetWork implements Serializable{

	/**
	 * 设备网络属性类
	 */
	private static final long serialVersionUID = 1L;
	
	//网络标识id
	private Integer networkId;
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
	@NotEmpty(message = "不能为空")
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
	@NotEmpty(message = "不能为空")
	private String  verificationDeadline;
	
	public NetWork() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetWork(Integer networkId, @NotEmpty(message = "不能为空") String transmissionType,
			@NotEmpty(message = "不能为空") String computerRoom, @NotEmpty(message = "不能为空") String networkAttribute,
			@NotEmpty(message = "不能为空") Integer idcard, @NotEmpty(message = "不能为空") String accessNetwork,
			@NotEmpty(message = "不能为空") String router, @NotEmpty(message = "不能为空") String networkTiming,
			@NotEmpty(message = "不能为空") String timingWarning, @NotEmpty(message = "不能为空") String verificationDeadline) {
		super();
		this.networkId = networkId;
		this.transmissionType = transmissionType;
		this.computerRoom = computerRoom;
		this.networkAttribute = networkAttribute;
		this.idcard = idcard;
		this.accessNetwork = accessNetwork;
		this.router = router;
		this.networkTiming = networkTiming;
		this.timingWarning = timingWarning;
		this.verificationDeadline = verificationDeadline;
	}

	@Override
	public String toString() {
		return "NetWork [networkId=" + networkId + ", transmissionType=" + transmissionType + ", computerRoom="
				+ computerRoom + ", networkAttribute=" + networkAttribute + ", idcard=" + idcard + ", accessNetwork="
				+ accessNetwork + ", router=" + router + ", networkTiming=" + networkTiming + ", timingWarning="
				+ timingWarning + ", verificationDeadline=" + verificationDeadline + "]";
	}

	public Integer getNetworkId() {
		return networkId;
	}

	public void setNetworkId(Integer networkId) {
		this.networkId = networkId;
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

	public String getVerificationDeadline() {
		return verificationDeadline;
	}

	public void setVerificationDeadline(String verificationDeadline) {
		this.verificationDeadline = verificationDeadline;
	}
	
	
	

}
