package com.yc.tc.equipment.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

public class Project implements Serializable{

	/**
	 * 项目类
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 项目标识id
	private Integer projectId;
	//采购日期
	@NotEmpty (message = "不能为空")
	private Timestamp purchaseDate;
	//安装日期          !!!!
	@NotEmpty (message = "不能为空")
	private Timestamp installDate;
	//承建单位
	@NotEmpty (message = "不能为空")
	private String contractor;
	//承建期别
	@NotEmpty (message = "不能为空")
	private String constructionPeriod;
	//建设单位
	@NotEmpty (message = "不能为空")
	private String buildUnit;
	//建设类型
	@NotEmpty (message = "不能为空")
	private String constructionType;
	//合同编号
	@NotEmpty (message = "不能为空")
	private String contractNumber;
	//建设状态
	@NotEmpty (message = "不能为空")
	private String constructionStatus;
	//施工单位
	@NotEmpty (message = "不能为空")
	private String constructionUnit;
	//建设项目
	@NotEmpty (message = "不能为空")
	private String constructionProject;
	//指向点位标识id 
	private Integer pointId;
	// 指向设备标识id 
	private Integer equipmentId;
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(Integer id, Integer projectId, @NotEmpty(message = "不能为空") Timestamp purchaseDate,
			@NotEmpty(message = "不能为空") Timestamp installDate, @NotEmpty(message = "不能为空") String contractor,
			@NotEmpty(message = "不能为空") String constructionPeriod, @NotEmpty(message = "不能为空") String buildUnit,
			@NotEmpty(message = "不能为空") String constructionType, @NotEmpty(message = "不能为空") String contractNumber,
			@NotEmpty(message = "不能为空") String constructionStatus, @NotEmpty(message = "不能为空") String constructionUnit,
			@NotEmpty(message = "不能为空") String constructionProject, Integer pointId, Integer equipmentId) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.purchaseDate = purchaseDate;
		this.installDate = installDate;
		this.contractor = contractor;
		this.constructionPeriod = constructionPeriod;
		this.buildUnit = buildUnit;
		this.constructionType = constructionType;
		this.contractNumber = contractNumber;
		this.constructionStatus = constructionStatus;
		this.constructionUnit = constructionUnit;
		this.constructionProject = constructionProject;
		this.pointId = pointId;
		this.equipmentId = equipmentId;
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", projectId=" + projectId + ", purchaseDate=" + purchaseDate + ", installDate="
				+ installDate + ", contractor=" + contractor + ", constructionPeriod=" + constructionPeriod
				+ ", buildUnit=" + buildUnit + ", constructionType=" + constructionType + ", contractNumber="
				+ contractNumber + ", constructionStatus=" + constructionStatus + ", constructionUnit="
				+ constructionUnit + ", constructionProject=" + constructionProject + ", pointId=" + pointId
				+ ", equipmentId=" + equipmentId + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Timestamp getInstallDate() {
		return installDate;
	}


	public void setInstallDate(Timestamp installDate) {
		this.installDate = installDate;
	}


	public String getContractor() {
		return contractor;
	}


	public void setContractor(String contractor) {
		this.contractor = contractor;
	}


	public String getConstructionPeriod() {
		return constructionPeriod;
	}


	public void setConstructionPeriod(String constructionPeriod) {
		this.constructionPeriod = constructionPeriod;
	}


	public String getBuildUnit() {
		return buildUnit;
	}


	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}


	public String getConstructionType() {
		return constructionType;
	}


	public void setConstructionType(String constructionType) {
		this.constructionType = constructionType;
	}


	public String getContractNumber() {
		return contractNumber;
	}


	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}


	public String getConstructionStatus() {
		return constructionStatus;
	}


	public void setConstructionStatus(String constructionStatus) {
		this.constructionStatus = constructionStatus;
	}


	public String getConstructionUnit() {
		return constructionUnit;
	}


	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}


	public String getConstructionProject() {
		return constructionProject;
	}


	public void setConstructionProject(String constructionProject) {
		this.constructionProject = constructionProject;
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
	
	
	
	 

}
