package com.lbadvisor.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbadvisor.work.entity.LbadvisorSubUser;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisService;
import com.lbadvisor.work.dao.LbadvisorSubUserDao;

/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorSubUser service 类
 * 
 * @date  2017年08月11日 12:56:54
 * @since     [工作日志 /service v1.0]
 */
@Service
public class LbadvisorSubUserService extends MyBatisService<LbadvisorSubUser, Integer> {

	@Autowired
	private LbadvisorSubUserDao lbadvisorSubUserDao;


	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存LbadvisorSubUser
	 * 
	 * @date 2017年08月11日 12:56:54
	 * @param lbadvisorSubUser
	 * @return
	 */
	public String saveLbadvisorSubUser(LbadvisorSubUser lbadvisorSubUser) {
		int rlt = 0;
		if(lbadvisorSubUser.getId() == 0){
			rlt = insert(lbadvisorSubUser);
		}else{
			rlt = update(lbadvisorSubUser);
		}
		if (rlt == 1) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除LbadvisorSubUser某条记录
	 * 
	 * @date 2017年08月11日 12:56:54
	 * @param id
	 *            lbadvisorSubUser ID
	 * @return
	 */
	public String delLbadvisorSubUserById(final int id) {
		final int rlt = delete(id);
		if (rlt == 1) {
			return "success";
		}
		return "fail";
	}

	@Override
	public MyBatisDao<LbadvisorSubUser, Integer> getMyBatisDao() {
		return lbadvisorSubUserDao;
	}

}