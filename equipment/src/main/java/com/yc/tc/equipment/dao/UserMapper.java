package com.yc.tc.equipment.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.tc.equipment.bean.User;

public interface UserMapper {
	//注册页面
	@Insert("insert into user values (null"
			+ ",#{name},#{password},#{phone}"
			+ ",#{plate_num},0,now(),123"
			+ ",123,#{email})")
   public  int insert(User user);

	@Select("select count(*) from user where name=#{name}")
	public int  countByName(String name);
    //登录页面
	@Select("select * from user where name=#{name} and password=#{password}")
	public User selectLogined(User user);
	
	//登录页面
		@Select("select * from user where name='郭婷' and password=#{password}")
		public User tselectLogined(User user);
	
		
	//用户管理页面-- 查询
	@Select("select * from user where name=#{name} or plate_num=#{plate_num} or phone=#{phone} or email=#{email}")
	public List<User> selectByU(User u);
	
	@Update("update user set name=#{name},plate_num=#{plate_num} ,phone=#{phone},email=#{email} where id=#{id}")
	public void updateByU(User u);
	
	//根据车牌号查询user id
	@Select("select id from user where plate_num=#{numid}")
	public int  selectidbynum(String numid);
	
	//根据userid 得到零钱
	@Select("select money from user where id=#{uid}")
	public double  selectpricbynid(int uid);
	
	//根据userid 更新金钱
	@Update("update user set money=#{pr} where id=#{uid}")
	public void uppricebyid(@Param("uid")int id,@Param("pr")double pric);
	
	//根据id修改user
	//if版 动态sql
		@Update({"<script> "
			    + "update user set "
				+ "<if test = 'name != null and name !=&apos;&apos;   '> "
				+" name=#{name},"
				+"</if>"
				+ "<if test = 'phone != null  and phone !=&apos;&apos;  '> "
				+"  phone=#{phone},"
				+"</if>"
				+ "<if test = 'plate_num != plate_num  and plate_num !=&apos;&apos;  '> "
				+" plate_num=#{plate_num},"
				+"</if>"
				+ "<if test = 'money != null  and money !=&apos;&apos;  '> "
				+" money=#{money},"
				+"</if>"
				+ "<if test = 'email != null  and email !=&apos;&apos;  '> "
				+" email=#{email},"
				+"</if>"
				+" id=#{id}  where id=#{id};"
				+"</script>"})
		public void upallbyid(User u);
		
		
		//根据id删除user
				@Delete("delete from user where id=#{id}")
				public void delectuser(User u);
	
}
