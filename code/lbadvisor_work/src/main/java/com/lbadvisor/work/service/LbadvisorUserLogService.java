package com.lbadvisor.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbadvisor.work.entity.LbadvisorUserLog;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisService;
import com.lbadvisor.work.dao.LbadvisorUserLogDao;

/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorUserLog service 类
 * 
 * @date  2017年08月11日 10:17:31
 * @since     [工作日志 /service v1.0]
 */
@Service
public class LbadvisorUserLogService extends MyBatisService<LbadvisorUserLog, Integer> {

	@Autowired
	private LbadvisorUserLogDao lbadvisorUserLogDao;


	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存LbadvisorUserLog
	 * 
	 * @date 2017年08月11日 10:17:31
	 * @param lbadvisorUserLog
	 * @return
	 */
	public String saveLbadvisorUserLog(LbadvisorUserLog lbadvisorUserLog) {
		int rlt = 0;
		if(lbadvisorUserLog.getId() == 0){
			rlt = insert(lbadvisorUserLog);
		}else{
			rlt = update(lbadvisorUserLog);
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
	 * 删除LbadvisorUserLog某条记录
	 * 
	 * @date 2017年08月11日 10:17:31
	 * @param id
	 *            lbadvisorUserLog ID
	 * @return
	 */
	public String delLbadvisorUserLogById(final int id) {
		final int rlt = delete(id);
		if (rlt == 1) {
			return "success";
		}
		return "fail";
	}

	@Override
	public MyBatisDao<LbadvisorUserLog, Integer> getMyBatisDao() {
		return lbadvisorUserLogDao;
	}

}