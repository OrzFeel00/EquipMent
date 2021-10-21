package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class Associated implements Serializable {

	/**
	 * 设备属性关联表  与设备类一对一
	 */
	private static final long serialVersionUID = 1L;
	//设备关联属性标识id
	private Integer associatedId ;
	//摄像机补光属性
	@NotEmpty(message = "不能为空")
    private String fillProperties;
    //摄像机功能类型
    @NotEmpty(message = "不能为空")
    private String functionType;
    //摄像机监控方位
    @NotEmpty(message = "不能为空")
    private String orientation;
    //摄像机位置类型
    @NotEmpty(message = "不能为空")
    private String positionType;
    //拾音器
    @NotEmpty(message = "不能为空")
    private String pickup;
    //信令安全模式
    @NotEmpty(message = "不能为空")
    private String securityMode;
    //注册方式
    @NotEmpty(message = "不能为空")
    private String regMethod;
    //保密属性
    @NotEmpty(message = "不能为空")
    private String confiAttribute;
    
    
	public Associated() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Associated(@NotEmpty(message = "不能为空") Integer associatedId,
			@NotEmpty(message = "不能为空") String fillProperties, @NotEmpty(message = "不能为空") String functionType,
			@NotEmpty(message = "不能为空") String orientation, @NotEmpty(message = "不能为空") String positionType,
			@NotEmpty(message = "不能为空") String pickup, @NotEmpty(message = "不能为空") String securityMode,
			@NotEmpty(message = "不能为空") String regMethod, @NotEmpty(message = "不能为空") String confiAttribute) {
		super();
		this.associatedId = associatedId;
		this.fillProperties = fillProperties;
		this.functionType = functionType;
		this.orientation = orientation;
		this.positionType = positionType;
		this.pickup = pickup;
		this.securityMode = securityMode;
		this.regMethod = regMethod;
		this.confiAttribute = confiAttribute;
	}




	@Override
	public String toString() {
		return "Associated [associatedId=" + associatedId + ", fillProperties=" + fillProperties + ", functionType="
				+ functionType + ", orientation=" + orientation + ", positionType=" + positionType + ", pickup="
				+ pickup + ", securityMode=" + securityMode + ", regMethod=" + regMethod + ", confiAttribute="
				+ confiAttribute + "]";
	}
	
	
	public Integer getAssociatedId() {
		return associatedId;
	}
	public void setAssociatedId(Integer associatedId) {
		this.associatedId = associatedId;
	}
	public String getFillProperties() {
		return fillProperties;
	}
	public void setFillProperties(String fillProperties) {
		this.fillProperties = fillProperties;
	}
	public String getFunctionType() {
		return functionType;
	}
	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getSecurityMode() {
		return securityMode;
	}
	public void setSecurityMode(String securityMode) {
		this.securityMode = securityMode;
	}
	public String getRegMethod() {
		return regMethod;
	}
	public void setRegMethod(String regMethod) {
		this.regMethod = regMethod;
	}
	public String getConfiAttribute() {
		return confiAttribute;
	}
	public void setConfiAttribute(String confiAttribute) {
		this.confiAttribute = confiAttribute;
	}
    
	
    
    

}
