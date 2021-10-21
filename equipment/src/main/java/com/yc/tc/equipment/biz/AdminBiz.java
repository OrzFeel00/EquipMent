package com.yc.tc.equipment.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Admin;
import com.yc.tc.equipment.dao.AdmiMapper;
@Service
public class AdminBiz {
	@Resource
	private AdmiMapper ampper;
	
	
	//登录验证
		public Admin Alogin(Admin adm) throws BizException {
			Admin dbAdm=ampper.selectAdminLogined(adm);
			if(dbAdm==null) {
				throw new BizException("管理员或者密码错误");
			}
			return dbAdm;
		}
}
