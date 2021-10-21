package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.yc.tc.equipment.validation.ipvalid;

public class Ip implements Serializable{

	/**
	 * ip信息类    点位和设备限制该类
	 */
	private static final long serialVersionUID = 1L;
	//ip标识id 主键
	private  Integer ipId;
	//ip地址
	@ipvalid
	private String ip;
	//mac地址   
	@NotEmpty(message = "不能为空")
	private String mac;
	//端口号
	@NotEmpty(message = "不能为空")
	private String prot;
	//判断是否当前使用的端口号，0是历史端口，1是正在使用的端口号
	private int isnow;
	
	public Ip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ip(Integer ipId, @NotEmpty(message = "不能为空") String ip, @NotEmpty(message = "不能为空") String mac,
			@NotEmpty(message = "不能为空") String prot, int isnow) {
		super();
		this.ipId = ipId;
		this.ip = ip;
		this.mac = mac;
		this.prot = prot;
		this.isnow = isnow;
	}

	@Override
	public String toString() {
		return "Ip [ipId=" + ipId + ", ip=" + ip + ", mac=" + mac + ", prot=" + prot + ", isnow=" + isnow + "]";
	}

	public Integer getIpId() {
		return ipId;
	}

	public void setIpId(Integer ipId) {
		this.ipId = ipId;
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

	public String getProt() {
		return prot;
	}

	public void setProt(String prot) {
		this.prot = prot;
	}

	public int getIsnow() {
		return isnow;
	}

	public void setIsnow(int isnow) {
		this.isnow = isnow;
	}
	
	
	

}
