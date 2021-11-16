package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class euiopmentall implements Serializable{
	
	/**
	 * 
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
		
		//摄像机补光属性
		@NotEmpty(message = "不能为空")
	    private String fillProperties;
	    //摄像机功能类型
	    @NotEmpty(message = "不能为空")
	    private String afunctionType;
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
	    
		//录像保存天数
		@NotEmpty(message = "不能为空")
		private String  storageDay;
		//录像地址
		@NotEmpty(message = "不能为空")
		private String  videoAddress;
		//码流类型
		@NotEmpty(message = "不能为空")
		private String  bitstreamType;
		//视频编码格式
		@NotEmpty(message = "不能为空")
		private String  codingFormat;
		//视频码率大小
		@NotEmpty(message = "不能为空")
		private String  bitrateSize;
		//视频码率类型
		@NotEmpty(message = "不能为空")
		private String  rateType;
		//图片格式
		@NotEmpty(message = "不能为空")
		private String  pictureFormat;
		
		//出厂序列号   唯一索引
		@NotEmpty(message = "不能为空")
		private String sn;
		//型号
		@NotEmpty(message = "不能为空")
		private String modelNumber;
		//硬盘数量  可以为0
		private int diskNumber;
		//图像帧率
		@NotEmpty(message = "不能为空")
		private String frameRate;
		//设备品牌
		@NotEmpty(message = "不能为空")
		private String brand;
		//图像分辨率
		@NotEmpty(message = "不能为空")
		private String resolvingPower;
		//设备功能类型
		@NotEmpty(message = "不能为空")
		private String functionType;
		//版本号
		@NotEmpty(message = "不能为空")
		private String versionNumber;
		//主机通道数    可以为0
		@NotNull(message = "不能为空")
		private Integer hostchannelsNumber;
		//设备高度
		@NotNull(message = "不能为空")
		private double height;
		//设备长度
		@NotNull(message = "不能为空")
		private double length;

		@Override
		public String toString() {
			return "euiopmentall [equipmentId=" + equipmentId + ", equipmentCode=" + equipmentCode + ", equipmentName="
					+ equipmentName + ", equipmentUser=" + equipmentUser + ", equipmentPwd=" + equipmentPwd
					+ ", equipmentType=" + equipmentType + ", fillProperties=" + fillProperties + ", afunctionType="
					+ afunctionType + ", orientation=" + orientation + ", positionType=" + positionType + ", pickup="
					+ pickup + ", securityMode=" + securityMode + ", regMethod=" + regMethod + ", confiAttribute="
					+ confiAttribute + ", storageDay=" + storageDay + ", videoAddress=" + videoAddress
					+ ", bitstreamType=" + bitstreamType + ", codingFormat=" + codingFormat + ", bitrateSize="
					+ bitrateSize + ", rateType=" + rateType + ", pictureFormat=" + pictureFormat + ", sn=" + sn
					+ ", modelNumber=" + modelNumber + ", diskNumber=" + diskNumber + ", frameRate=" + frameRate
					+ ", brand=" + brand + ", resolvingPower=" + resolvingPower + ", functionType=" + functionType
					+ ", versionNumber=" + versionNumber + ", hostchannelsNumber=" + hostchannelsNumber + ", height="
					+ height + ", length=" + length + "]";
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

		public String getFillProperties() {
			return fillProperties;
		}

		public void setFillProperties(String fillProperties) {
			this.fillProperties = fillProperties;
		}

		public String getAfunctionType() {
			return afunctionType;
		}

		public void setAfunctionType(String afunctionType) {
			this.afunctionType = afunctionType;
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

		public String getStorageDay() {
			return storageDay;
		}

		public void setStorageDay(String storageDay) {
			this.storageDay = storageDay;
		}

		public String getVideoAddress() {
			return videoAddress;
		}

		public void setVideoAddress(String videoAddress) {
			this.videoAddress = videoAddress;
		}

		public String getBitstreamType() {
			return bitstreamType;
		}

		public void setBitstreamType(String bitstreamType) {
			this.bitstreamType = bitstreamType;
		}

		public String getCodingFormat() {
			return codingFormat;
		}

		public void setCodingFormat(String codingFormat) {
			this.codingFormat = codingFormat;
		}

		public String getBitrateSize() {
			return bitrateSize;
		}

		public void setBitrateSize(String bitrateSize) {
			this.bitrateSize = bitrateSize;
		}

		public String getRateType() {
			return rateType;
		}

		public void setRateType(String rateType) {
			this.rateType = rateType;
		}

		public String getPictureFormat() {
			return pictureFormat;
		}

		public void setPictureFormat(String pictureFormat) {
			this.pictureFormat = pictureFormat;
		}

		public String getSn() {
			return sn;
		}

		public void setSn(String sn) {
			this.sn = sn;
		}

		public String getModelNumber() {
			return modelNumber;
		}

		public void setModelNumber(String modelNumber) {
			this.modelNumber = modelNumber;
		}

		public int getDiskNumber() {
			return diskNumber;
		}

		public void setDiskNumber(int diskNumber) {
			this.diskNumber = diskNumber;
		}

		public String getFrameRate() {
			return frameRate;
		}

		public void setFrameRate(String frameRate) {
			this.frameRate = frameRate;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getResolvingPower() {
			return resolvingPower;
		}

		public void setResolvingPower(String resolvingPower) {
			this.resolvingPower = resolvingPower;
		}

		public String getFunctionType() {
			return functionType;
		}

		public void setFunctionType(String functionType) {
			this.functionType = functionType;
		}

		public String getVersionNumber() {
			return versionNumber;
		}

		public void setVersionNumber(String versionNumber) {
			this.versionNumber = versionNumber;
		}

		public Integer getHostchannelsNumber() {
			return hostchannelsNumber;
		}

		public void setHostchannelsNumber(Integer hostchannelsNumber) {
			this.hostchannelsNumber = hostchannelsNumber;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public double getLength() {
			return length;
		}

		public void setLength(double length) {
			this.length = length;
		}

		private euiopmentall(Integer equipmentId, @NotEmpty(message = "不能为空") String equipmentCode,
				@NotEmpty(message = "不能为空") String equipmentName, @NotEmpty(message = "不能为空") String equipmentUser,
				@NotEmpty(message = "不能为空") String equipmentPwd, @NotEmpty(message = "不能为空") String equipmentType,
				@NotEmpty(message = "不能为空") String fillProperties, @NotEmpty(message = "不能为空") String afunctionType,
				@NotEmpty(message = "不能为空") String orientation, @NotEmpty(message = "不能为空") String positionType,
				@NotEmpty(message = "不能为空") String pickup, @NotEmpty(message = "不能为空") String securityMode,
				@NotEmpty(message = "不能为空") String regMethod, @NotEmpty(message = "不能为空") String confiAttribute,
				@NotEmpty(message = "不能为空") String storageDay, @NotEmpty(message = "不能为空") String videoAddress,
				@NotEmpty(message = "不能为空") String bitstreamType, @NotEmpty(message = "不能为空") String codingFormat,
				@NotEmpty(message = "不能为空") String bitrateSize, @NotEmpty(message = "不能为空") String rateType,
				@NotEmpty(message = "不能为空") String pictureFormat, @NotEmpty(message = "不能为空") String sn,
				@NotEmpty(message = "不能为空") String modelNumber, int diskNumber,
				@NotEmpty(message = "不能为空") String frameRate, @NotEmpty(message = "不能为空") String brand,
				@NotEmpty(message = "不能为空") String resolvingPower, @NotEmpty(message = "不能为空") String functionType,
				@NotEmpty(message = "不能为空") String versionNumber, @NotNull(message = "不能为空") Integer hostchannelsNumber,
				@NotNull(message = "不能为空") double height, @NotNull(message = "不能为空") double length) {
			super();
			this.equipmentId = equipmentId;
			this.equipmentCode = equipmentCode;
			this.equipmentName = equipmentName;
			this.equipmentUser = equipmentUser;
			this.equipmentPwd = equipmentPwd;
			this.equipmentType = equipmentType;
			this.fillProperties = fillProperties;
			this.afunctionType = afunctionType;
			this.orientation = orientation;
			this.positionType = positionType;
			this.pickup = pickup;
			this.securityMode = securityMode;
			this.regMethod = regMethod;
			this.confiAttribute = confiAttribute;
			this.storageDay = storageDay;
			this.videoAddress = videoAddress;
			this.bitstreamType = bitstreamType;
			this.codingFormat = codingFormat;
			this.bitrateSize = bitrateSize;
			this.rateType = rateType;
			this.pictureFormat = pictureFormat;
			this.sn = sn;
			this.modelNumber = modelNumber;
			this.diskNumber = diskNumber;
			this.frameRate = frameRate;
			this.brand = brand;
			this.resolvingPower = resolvingPower;
			this.functionType = functionType;
			this.versionNumber = versionNumber;
			this.hostchannelsNumber = hostchannelsNumber;
			this.height = height;
			this.length = length;
		}

		private euiopmentall() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		

}
