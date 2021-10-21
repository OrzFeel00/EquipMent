package com.yc.tc.equipment.bean;


import javax.validation.constraints.NotEmpty;


public class Admin implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message="用户名不能为空")
	private String adm;
	@NotEmpty(message="密码不能为空")
	private String pwd;
	
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adm=" + adm + ", pwd=" + pwd + "]";
	}
	

	public Admin(Integer id, @NotEmpty(message = "用户名不能为空") String adm, @NotEmpty(message = "密码不能为空") String pwd) {
		super();
		this.id = id;
		this.adm = adm;
		this.pwd = pwd;
	}



	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	


	
}
