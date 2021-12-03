package com.yc.tc.equipment.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.yc.tc.equipment.bean.Equipment;
import com.yc.tc.equipment.bean.Installation;
import com.yc.tc.equipment.bean.PointPosition;
import com.yc.tc.equipment.bean.ip;
import com.yc.tc.equipment.dao.InstallationMapper;
import com.yc.tc.equipment.dao.PointPositionMapper;
import com.yc.tc.equipment.dao.ipMapper;
import com.yc.tc.equipment.util.instUtils2;

@Service
public class InstallationBiz {

		@Resource
		private PointPositionMapper pmpper;
		@Resource
		private InstallationMapper  impper;
		@Resource
		private ipMapper  ipmpper;
	
	   //ins验证
		public void addinstall(Installation install)throws BizException {
			
		   
				impper.insertinstall(install);
		
			}

	            	//找到所有的点位名称
				public List<String> selectAllPointNames() {
					List<String> pionlist=pmpper.selectAllPointNames();  
					return pionlist;
				}
				
				//查询所有点位
				public List<Installation> selectAllinstall()throws BizException {
					if(impper.selectAllinstall()==null) {
						throw new BizException("暂时没有记录点位");
					}					
					return impper.selectAllinstall();
				}
				
				//根据id擦寻名称
				public String selectpointnameByid(int pid) {
					 
					return  pmpper.selectnameByid(pid);
				}
				
				//删除点位
				public void dellinstall(int id) {
					impper.delectinstallById(id);
				}
				//根据id查询inst
				public Installation selectInstallById(Integer insid) {				
					
					return  impper.selectInstallById(insid);
				}
				//根据条件模糊查询
				public List<Installation> selectinstallBymore(Installation install)throws BizException {
					
					return impper.selectinstallBymore(install);
				}
				//修改点位
				public void updateinstallById(Installation install)throws BizException {
				
					
					impper.updateinstallById(install);
				}
                 //添加旧端口
				public void addip(Installation install) {
					ip ip=new ip();
				  ip.setPointName(install.getPointName()); 
				  ip.setEquipmentName(install.getEquipmentName());	
				  ip.setIp(install.getIp());	
			      ip.setMac(install.getMac());	
				  ip.setProt(install.getProt());
				  //存入ip
				  //1判断是否存在该历史ip
				  if(ipmpper.countByipmor(ip)>0) {
					  return;
				  }
				  ipmpper.insertip(ip);
				  
				}
				
				//根据设备和点位得到历史端口
				public List<ip> selectipbyname(ip p){
					
					return ipmpper.selectipbyname(p);
				}
               //回收ip里的点位和设备
				public void dellinsformip(Installation install) {
					// TODO Auto-generated method stub
					//根据点位设备组查重
					if(impper.countBypnen(install)>0) {
						return;
					}
					//如果已经没有了这个install信息,则删除ip对应的点位设备组
					
					ipmpper.deleteIpByPnEn(install);
					
				}
				

}
