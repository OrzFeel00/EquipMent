package com.yc.tc.equipment.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class Storage implements Serializable{

	/**
	 * 设备存储信息类   和设备类一对一
	 */
	private static final long serialVersionUID = 1L;
    //存储标识id
	private Integer  storageId;
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
	
	
	public Storage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Storage(Integer storageId, @NotEmpty(message = "不能为空") String storageDay,
			@NotEmpty(message = "不能为空") String videoAddress, @NotEmpty(message = "不能为空") String bitstreamType,
			@NotEmpty(message = "不能为空") String codingFormat, @NotEmpty(message = "不能为空") String bitrateSize,
			@NotEmpty(message = "不能为空") String rateType, @NotEmpty(message = "不能为空") String pictureFormat) {
		super();
		this.storageId = storageId;
		this.storageDay = storageDay;
		this.videoAddress = videoAddress;
		this.bitstreamType = bitstreamType;
		this.codingFormat = codingFormat;
		this.bitrateSize = bitrateSize;
		this.rateType = rateType;
		this.pictureFormat = pictureFormat;
	}


	@Override
	public String toString() {
		return "Storage [storageId=" + storageId + ", storageDay=" + storageDay + ", videoAddress=" + videoAddress
				+ ", bitstreamType=" + bitstreamType + ", codingFormat=" + codingFormat + ", bitrateSize=" + bitrateSize
				+ ", rateType=" + rateType + ", pictureFormat=" + pictureFormat + "]";
	}


	public Integer getStorageId() {
		return storageId;
	}


	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
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
	
	
	
	
	
	
}
