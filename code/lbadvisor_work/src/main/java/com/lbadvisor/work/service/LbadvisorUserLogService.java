package com.lbadvisor.work.service;

import com.lbadvisor.work.dao.LbadvisorUserDao;
import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbadvisor.work.entity.LbadvisorUserLog;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisService;
import com.lbadvisor.work.dao.LbadvisorUserLogDao;

import java.util.List;

/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorUserLog service 类
 * 
 * @date  2017年08月11日 12:56:54
 * @since     [工作日志 /service v1.0]
 */
@Service
public class LbadvisorUserLogService extends MyBatisService<LbadvisorUserLog, Integer> {

	@Autowired
	private LbadvisorUserLogDao lbadvisorUserLogDao;

	@Autowired
	private LbadvisorUserDao lbadvisorUserDao;


	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存LbadvisorUserLog
	 * 
	 * @date 2017年08月11日 12:56:54
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
	 * @date 2017年08月11日 12:56:54
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

	public Response findUserLogByopenid(String openid) {
		if (null  == openid) {
			return new Response().failure( "openid is null ! " );
		}
		LbadvisorUser user = lbadvisorUserDao.getByOpenId( openid );
		if (null == user) {
			return new Response().failure( "This user is not exist ! " );
		}
		int userId = user.getId();
		List<LbadvisorUserLog> lbadvisorUserLogDaoByUserId = lbadvisorUserLogDao.getByUserId( String.valueOf( userId ) );
		if (null == lbadvisorUserLogDaoByUserId) {
			return new Response().failure( "This userLog is not exist ! " );
		}
		return new Response().success(lbadvisorUserLogDaoByUserId);
	}
	@Override
	public MyBatisDao<LbadvisorUserLog, Integer> getMyBatisDao() {
		return lbadvisorUserLogDao;
	}

}