package com.yc.tc.equipment.bean;

import java.io.Serializable;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Project implements Serializable{

	/**
	 * 项目类
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 项目名称
	@NotEmpty (message = "不能为空")
	private String projectName;
	//采购日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")//出
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")//入
	private Date purchaseDate;
	//安装日期          !!!!
	//@NotNull (message = "不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date installDate;
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
	private String pointName;
	// 指向设备标识id 
	private String equipmentName;
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	private Project(Integer id, @NotEmpty(message = "不能为空") String projectName, Date purchaseDate, Date installDate,
			@NotEmpty(message = "不能为空") String contractor, @NotEmpty(message = "不能为空") String constructionPeriod,
			@NotEmpty(message = "不能为空") String buildUnit, @NotEmpty(message = "不能为空") String constructionType,
			@NotEmpty(message = "不能为空") String contractNumber, @NotEmpty(message = "不能为空") String constructionStatus,
			@NotEmpty(message = "不能为空") String constructionUnit, @NotEmpty(message = "不能为空") String constructionProject,
			String pointName, String equipmentName) {
		super();
		this.id = id;
		this.projectName = projectName;
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
		this.pointName = pointName;
		this.equipmentName = equipmentName;
	}




	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", purchaseDate=" + purchaseDate
				+ ", installDate=" + installDate + ", contractor=" + contractor + ", constructionPeriod="
				+ constructionPeriod + ", buildUnit=" + buildUnit + ", constructionType=" + constructionType
				+ ", contractNumber=" + contractNumber + ", constructionStatus=" + constructionStatus
				+ ", constructionUnit=" + constructionUnit + ", constructionProject=" + constructionProject
				+ ", pointName=" + pointName + ", equipmentName=" + equipmentName + "]";
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Date getInstallDate() {
		return installDate;
	}


	public void setInstallDate(Date installDate) {
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


	


	
	
	
	 

}
