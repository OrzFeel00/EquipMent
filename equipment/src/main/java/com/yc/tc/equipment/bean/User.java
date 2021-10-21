package com.yc.tc.equipment.bean;


import javax.validation.constraints.NotEmpty;


public class User implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户id主键
	private Integer uid;
	@NotEmpty(message="用户名不能为空")
	private String name;
	@NotEmpty(message="密码不能为空")
	private String pwd;
	//用户权限
	@NotEmpty(message="权限不能为空")
	private int grade;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public User(Integer uid, @NotEmpty(message = "用户名不能为空") String name, @NotEmpty(message = "密码不能为空") String pwd,
			int grade) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.grade = grade;
	}




	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", pwd=" + pwd + ", grade=" + grade + "]";
	}




	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	

}
