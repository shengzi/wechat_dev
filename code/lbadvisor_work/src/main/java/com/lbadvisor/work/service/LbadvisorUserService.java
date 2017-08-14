package com.lbadvisor.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbadvisor.work.entity.LbadvisorUser;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisDao;
import com.lbadvisor.work.utils.orm.mybatis.MyBatisService;
import com.lbadvisor.work.dao.LbadvisorUserDao;

/**
 * <B>功能简述</B><br>
 * LbadvisorUser service 类
 *
 * @date 2017年08月11日 12:56:54
 * @since [工作日志 /service v1.0]
 */
@Service
public class LbadvisorUserService extends MyBatisService<LbadvisorUser, Integer> {

    @Autowired
    private LbadvisorUserDao lbadvisorUserDao;


    /**
     * <B>功能简述</B><br>
     * 保存LbadvisorUser
     *
     * @param lbadvisorUser
     * @return
     * @date 2017年08月11日 12:56:54
     */
    public String saveLbadvisorUser(LbadvisorUser lbadvisorUser) {
        int rlt = 0;
        if (lbadvisorUser.getId() == 0) {
            rlt = insert(lbadvisorUser);
        } else {
            rlt = update(lbadvisorUser);
        }
        if (rlt == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * <B>功能简述</B><br>
     * 删除LbadvisorUser某条记录
     *
     * @param id lbadvisorUser ID
     * @return
     * @date 2017年08月11日 12:56:54
     */
    public String delLbadvisorUserById(final int id) {
        final int rlt = delete(id);
        if (rlt == 1) {
            return "success";
        }
        return "fail";
    }

    @Override
    public MyBatisDao<LbadvisorUser, Integer> getMyBatisDao() {
        return lbadvisorUserDao;
    }

    public LbadvisorUser getByOpenid(String openid) {
        return lbadvisorUserDao.getByOpenId(openid);
    }
}