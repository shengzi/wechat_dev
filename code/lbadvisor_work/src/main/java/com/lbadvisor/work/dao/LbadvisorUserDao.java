package com.lbadvisor.work.dao;

import org.springframework.stereotype.Component;
import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;

/**
 * 
 * <B>功能简述</B><br>
 * LbadvisorUser dao 类
 * 
 * @date  2017年08月11日 12:56:54
 * @since     [工作日志 /dao v1.0]
 */
@Component
public class LbadvisorUserDao extends MyBatisDao<LbadvisorUser, Integer>{

    /**
     * 根据openId获取用户
     * @param openid
     * @return
     */
    public LbadvisorUser getByOpenId(String openid) {
        return getSqlSession().selectOne("getByOpenId",openid);
    }
} 