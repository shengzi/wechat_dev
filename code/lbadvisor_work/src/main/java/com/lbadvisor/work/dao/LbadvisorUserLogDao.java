package com.lbadvisor.work.dao;

import org.springframework.stereotype.Component;
import com.lbadvisor.work.entity.LbadvisorUserLog;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;

import java.util.List;

/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorUserLog dao 类
 * 
 * @date  2017年08月11日 12:56:54
 * @since     [工作日志 /dao v1.0]
 */
@Component
public class LbadvisorUserLogDao extends MyBatisDao<LbadvisorUserLog, Integer>{

    /**
     * 根据userId获取用户日志
     * @param userId
     * @return
     */
    public List<LbadvisorUserLog> getByUserId(String userId) {
        return getSqlSession().selectList("getByUserId",userId);
    }
} 