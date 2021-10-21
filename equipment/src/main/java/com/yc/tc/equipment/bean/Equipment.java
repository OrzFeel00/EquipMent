package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class Equipment implements Serializable {

	/**
	 * 设备类（也是基础表）
	 */
	private static final long serialVersionUID = 1L;
	//设备标识id
	private Integer equipmentId;
	//设备编号
	@NotEmpty(message = "不能为空")
	private String  equipmentCode;
	//设备名称
	@NotEmpty(message = "不能为空")
	private String  equipmentName;
	//设备用户名
	@NotEmpty(message = "不能为空")
	private String  equipmentUser;
	//设备密码
	@NotEmpty(message = "不能为空")
	private String  equipmentPwd;
	//设备类型
	@NotEmpty(message = "不能为空")
	private String  equipmentType;
	//指向 关联设备表标识id  1-1对应
	private Integer  associatedId;
	//指向 存储表标识id 1-1对应
	private Integer  storageId;
	//指向 基础设备信息表标识id 1-1对应
	private Integer  baseEquipmentId;
	
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Equipment(Integer equipmentId, @NotEmpty(message = "不能为空") String equipmentCode,
			@NotEmpty(message = "不能为空") String equipmentName, @NotEmpty(message = "不能为空") String equipmentUser,
			@NotEmpty(message = "不能为空") String equipmentPwd, @NotEmpty(message = "不能为空") String equipmentType,
			Integer associatedId, Integer storageId, Integer baseEquipmentId) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentCode = equipmentCode;
		this.equipmentName = equipmentName;
		this.equipmentUser = equipmentUser;
		this.equipmentPwd = equipmentPwd;
		this.equipmentType = equipmentType;
		this.associatedId = associatedId;
		this.storageId = storageId;
		this.baseEquipmentId = baseEquipmentId;
	}



	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentCode=" + equipmentCode + ", equipmentName="
				+ equipmentName + ", equipmentUser=" + equipmentUser + ", equipmentPwd=" + equipmentPwd
				+ ", equipmentType=" + equipmentType + ", associatedId=" + associatedId + ", storageId=" + storageId
				+ ", baseEquipmentId=" + baseEquipmentId + "]";
	}
	
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentCode() {
		return equipmentCode;
	}
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentUser() {
		return equipmentUser;
	}
	public void setEquipmentUser(String equipmentUser) {
		this.equipmentUser = equipmentUser;
	}
	public String getEquipmentPwd() {
		return equipmentPwd;
	}
	public void setEquipmentPwd(String equipmentPwd) {
		this.equipmentPwd = equipmentPwd;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public Integer getAssociatedId() {
		return associatedId;
	}
	public void setAssociatedId(Integer associatedId) {
		this.associatedId = associatedId;
	}
	public Integer getStorageId() {
		return storageId;
	}
	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}
	public Integer getBaseEquipmentId() {
		return baseEquipmentId;
	}
	public void setBaseEquipmentId(Integer baseEquipmentId) {
		this.baseEquipmentId = baseEquipmentId;
	}
	
	
	

}
