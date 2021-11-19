package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ip implements Serializable {

	/**
	 * 道路表    名称会有正反两种称呼 但是共用一个编号
	 */
	private static final long serialVersionUID = 1L;
	//id
	private Integer id;
	//点位名称
	@NotEmpty (message = "不能为空")
	private String pointName;
	//设备名称
	@NotEmpty (message = "不能为空")
	private String equipmentName;
	//IP地址
	@NotEmpty (message = "不能为空")
	private String ip;
	//mac地址
	@NotEmpty (message = "不能为空")
	private String mac;
	//端口号   
	@NotNull (message = "不能为空")
	private Integer prot;
	
	public ip() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ip(Integer id, @NotEmpty(message = "不能为空") String pointName,
			@NotEmpty(message = "不能为空") String equipmentName, @NotEmpty(message = "不能为空") String ip,
			@NotEmpty(message = "不能为空") String mac, @NotNull(message = "不能为空") Integer prot) {
		super();
		this.id = id;
		this.pointName = pointName;
		this.equipmentName = equipmentName;
		this.ip = ip;
		this.mac = mac;
		this.prot = prot;
	}

	@Override
	public String toString() {
		return "ip [id=" + id + ", pointName=" + pointName + ", equipmentName=" + equipmentName + ", ip=" + ip
				+ ", mac=" + mac + ", prot=" + prot + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getProt() {
		return prot;
	}

	public void setProt(Integer prot) {
		this.prot = prot;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	

}
